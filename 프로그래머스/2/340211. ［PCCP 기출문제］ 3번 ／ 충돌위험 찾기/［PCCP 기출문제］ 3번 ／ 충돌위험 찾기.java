import java.util.*;
class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 값이 같으면 같은 객체로 인식하도록 오버라이딩
        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Point point = (Point) object;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Robot {
        int idx; // 로봇 번호
        Point cur; // 현재 위치
        int targetIdx; // 목적지 idx
        Point target; // 목적지 위치

        public Robot(int idx, Point cur, int targetIdx, Point target) {
            this.idx = idx;
            this.cur = cur;
            this.targetIdx = targetIdx;
            this.target = target;
        }

        public void move() {
            // 한칸 이동
            if (this.cur.x != this.target.x) {
                if (this.cur.x < this.target.x) {
                    this.cur.x++;
                } else {
                    this.cur.x--;
                }
            } else {
                if (this.cur.y < this.target.y) {
                    this.cur.y++;
                } else {
                    this.cur.y--;
                }
            }
        }
    }
    public int solution(int[][] points, int[][] routes) {
        int n = routes.length; // 로봇의 개수
        ArrayList<Point> list = new ArrayList<>(); // 각 시간마다 초기화하면서 좌표들을 담을 list
        HashSet<Point> set = new HashSet<>(); // 충돌이 발생한 좌표를 담는 set
        int cnt = 0;
        Queue<Robot> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 각 로봇의 시작 지점 넣어주고 로봇 객체 생성
            int x = points[routes[i][0] - 1][0];
            int y = points[routes[i][0] - 1][1];
            int dx = points[routes[i][1] - 1][0];
            int dy = points[routes[i][1] - 1][1];
            Point cur = new Point(x, y);
            Point target = new Point(dx, dy);
            Robot robot = new Robot(i, cur, 1, target);
            queue.add(robot);

            // 이미 해당 칸에 로봇이 있다면 충돌 set에 넣어줌
            if(list.contains(cur)) {
                set.add(cur);
            } else {
                list.add(cur);
            }
        }

        while (!queue.isEmpty() && n > 0) {
            int size = queue.size();

            // 이동 전 충돌 위험이 있었는지 확인
            if (!set.isEmpty()) {
                cnt += set.size();
            }

            // set 초기화, list 초기화
            set = new HashSet<>();
            list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Robot robot = queue.poll();

                // 현재 위치가 목적지라면 목적지 idx 증가
                if (robot.cur.x == robot.target.x && robot.cur.y == robot.target.y) {
                    robot.targetIdx++;
                    // 모든 목적지 달성시 패스
                    if (robot.targetIdx >= routes[0].length) {
                        n--;
                        continue;
                    } else {
                        // 아니라면 새로운 목적지로 변경
                        int tx = points[routes[robot.idx][robot.targetIdx] - 1][0];
                        int ty = points[routes[robot.idx][robot.targetIdx] - 1][1];
                        robot.target = new Point(tx, ty);
                    }
                }

                // 한칸 이동
                robot.move();

                // 최대 배열을 넘어가면 패스
                if (robot.cur.x <= 0 || robot.cur.y <= 0 || robot.cur.x > 100 || robot.cur.y > 100) {
                    continue;
                }

                queue.add(robot);
                Point point = new Point(robot.cur.x, robot.cur.y);
                if (list.contains(point)) {
                    set.add(point);
                } else {
                    list.add(point);
                }
            }
        }

        return cnt;
    }
}