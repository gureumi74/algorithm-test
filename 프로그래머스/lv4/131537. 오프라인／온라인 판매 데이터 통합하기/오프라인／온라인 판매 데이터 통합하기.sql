-- 2022년 3월의 오프라인/온라인 상품 판매 데이터
-- 판매 날짜, 상품ID, 유저ID, 판매량
-- OFFLINE SALE 테이블의 USER_ID 값 NULL
-- 판매일 기준 오름차순, 상품 ID 오름차순, 유저 ID 오름차순
SELECT *
FROM(
    SELECT
        DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    FROM ONLINE_SALE
    UNION ALL
    SELECT
        DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE,
        PRODUCT_ID,
        NULL USER_ID,
        SALES_AMOUNT
    FROM OFFLINE_SALE
) T
WHERE T.SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID