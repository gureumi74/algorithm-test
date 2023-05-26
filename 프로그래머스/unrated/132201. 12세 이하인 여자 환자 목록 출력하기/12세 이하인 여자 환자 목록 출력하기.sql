-- 12세 이하 여자환자 환자이름, 환자번호, 성별코드, 나이, 전화번호
-- 전화번호가 없는 경우 NONE 출력
-- 나이 내림차순, 환자이름 오름차순
SELECT 
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    IFNULL(TLNO, 'NONE')
FROM PATIENT
WHERE AGE <= 12
AND GEND_CD IN ('W')
ORDER BY AGE DESC, PT_NAME