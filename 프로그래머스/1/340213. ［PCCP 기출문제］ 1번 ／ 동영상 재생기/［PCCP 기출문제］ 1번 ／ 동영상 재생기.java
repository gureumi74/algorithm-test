import java.time.LocalTime;
class Solution {
    // 문자열 시간을 LocalTime 으로 반환
    public static LocalTime timeSet(String timeStr) {
        String[] timeArr = timeStr.split(":");
        LocalTime time = LocalTime.of(0, Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1]));

        return time;
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        LocalTime videoLenTime = timeSet(video_len);
        LocalTime posTime = timeSet(pos);
        LocalTime opStartTime = timeSet(op_start);
        LocalTime opEndTime = timeSet(op_end);

        // 오프닝 건너뛰기
        if((posTime.equals(opStartTime) || posTime.isAfter(opStartTime)) && (posTime.equals(opEndTime) || posTime.isBefore(opEndTime))) {
            posTime = opEndTime;
        }
        
        for(int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) {
                int curTime = posTime.toSecondOfDay();
                if (curTime - 10 < 0) {
                    posTime = LocalTime.of(0, 0, 0);
                } else {
                    posTime = posTime.minusSeconds(10);
                }
            } else if (commands[i].equals("next")) {
                posTime = posTime.plusSeconds(10);

                if(posTime.isAfter(videoLenTime)) {
                    posTime = videoLenTime;
                }
            }

            // 오프닝 건너뛰기
        if((posTime.equals(opStartTime) || posTime.isAfter(opStartTime)) && (posTime.equals(opEndTime) || posTime.isBefore(opEndTime))) {
            posTime = opEndTime;
        }
        }
        String answer = String.format("%02d:%02d", posTime.getMinute(), posTime.getSecond());
        return answer;
    }
}