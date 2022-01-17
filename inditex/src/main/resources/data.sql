DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES(ID INT AUTO_INCREMENT PRIMARY KEY,
                    BRAND_ID INT NOT NULL,
                    START_DATE TIMESTAMP,
                    END_DATE TIMESTAMP,
                    PRICE_LIST INT,
                    PRODUCT_ID INT NOT NULL,
                    PRIORITY INT,
                    PRICE DOUBLE,
                    CURR VARCHAR(10) NOT NULL);

INSERT INTO PRICES(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES(1, parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES(1, parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-hh.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES(1, parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-hh.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES(1, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 4, 35455, 1, 38.95, 'EUR');
