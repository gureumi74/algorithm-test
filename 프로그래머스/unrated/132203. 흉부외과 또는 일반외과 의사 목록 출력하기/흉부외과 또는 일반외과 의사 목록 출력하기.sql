-- 진료과 CS, GS인 의사의 이름, 의사 ID, 진료과, 고용일자 / 고용일자 내림차순, 이름 오름차순
SELECT
    DR_NAME,
    DR_ID,
    MCDP_CD,
    DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD IN ('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME