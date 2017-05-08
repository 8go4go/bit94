
CREATE TABLE USR
(
	USR_NO                INTEGER NULL,
	USRID                 VARCHAR(10) NOT NULL,
	PASSWD                VARCHAR(10) NOT NULL,
	EMAIL                 VARCHAR(50) NOT NULL,
	TELNO                 VARCHAR(13) NOT NULL,
	ZIPNO                 CHAR(6) NOT NULL,
	ADDRESS               VARCHAR(200) NOT NULL,
	REG_DATE              DATE NOT NULL,
	USR_CD                CHAR(1) NOT NULL,
	CRE_DEG_CD            CHAR(1) NOT NULL,
	 PRIMARY KEY (USR_NO)
)
;



CREATE UNIQUE INDEX IDX_USR_PK ON USR
(
	USR_NO
)
;



CREATE UNIQUE INDEX IDX_USR_SEARCH ON USR
(
	REG_DATE,
	USR_CD,
	CRE_DEG_CD
)
;



CREATE TABLE MGR
(
	MGR_NO                INTEGER NULL,
	HIGH_MGR_NO           INTEGER NULL,
	MGRID                 VARCHAR(10) NOT NULL,
	PASSWD                VARCHAR(10) NOT NULL,
	MGR_NM                VARCHAR(10) NOT NULL,
	TELNO                 VARCHAR(13) NOT NULL,
	EMAIL                 VARCHAR(50) NOT NULL,
	 PRIMARY KEY (MGR_NO)FOREIGN KEY R_51 (HIGH_MGR_NO) REFERENCES MGR(MGR_NO)
)
;



CREATE UNIQUE INDEX IDX_MGR_PK ON MGR
(
	MGR_NO
)
;



CREATE UNIQUE INDEX IDX_MGR_NM ON MGR
(
	MGR_NM
)
;



CREATE TABLE PRD_TYPE
(
	PRD_TYPE_CD           CHAR(18) NULL,
	HIGH_PRD_TYPE_CD      CHAR(18) NULL,
	PRD_TYPE_NM           CHAR(18) NULL,
	MGR_NO                INTEGER NOT NULL,
	 PRIMARY KEY (PRD_TYPE_CD)FOREIGN KEY R_14 (HIGH_PRD_TYPE_CD) REFERENCES PRD_TYPE(PRD_TYPE_CD),
	FOREIGN KEY R_45 (MGR_NO) REFERENCES MGR(MGR_NO)
)
;



CREATE UNIQUE INDEX IDX_PRD_TYPE_PK ON PRD_TYPE
(
	PRD_TYPE_CD
)
;



CREATE TABLE AUCTION_TYPE
(
	TYPE_CD               CHAR(1) NULL,
	TYPE_NM               VARCHAR(50) NOT NULL,
	TYPE_CONT             VARCHAR(200) NULL,
	 PRIMARY KEY (TYPE_CD)
)
;



CREATE UNIQUE INDEX IDX_AUCTION_TYPE_PK ON AUCTION_TYPE
(
	TYPE_CD
)
;



CREATE TABLE AUCTION
(
	REG_NO                CHAR(18) NULL,
	REG_DATE              CHAR(18) NOT NULL,
	LOW_PRICE             CHAR(18) NOT NULL,
	PRD_NM                CHAR(18) NOT NULL,
	QTY                   CHAR(18) NOT NULL,
	START_DATE            CHAR(18) NOT NULL,
	END_DATE              CHAR(18) NOT NULL,
	USR_NO                INTEGER NOT NULL,
	PRD_TYPE_CD           CHAR(18) NOT NULL,
	TYPE_CD               CHAR(1) NOT NULL,
	MGR_NO                INTEGER NOT NULL,
	APPRO_CD              CHAR(1) NOT NULL,
	REVIEW_CNT            INTEGER NULL,
	�źλ���              VARCHAR(200) NULL,
	 PRIMARY KEY (REG_NO)FOREIGN KEY R_15 (USR_NO) REFERENCES USR(USR_NO),
	FOREIGN KEY R_16 (PRD_TYPE_CD) REFERENCES PRD_TYPE(PRD_TYPE_CD),
	FOREIGN KEY R_18 (TYPE_CD) REFERENCES AUCTION_TYPE(TYPE_CD),
	FOREIGN KEY R_46 (MGR_NO) REFERENCES MGR(MGR_NO)
)
;



CREATE UNIQUE INDEX IDX_PK_AUCTION ON AUCTION
(
	REG_NO
)
;



CREATE UNIQUE INDEX IDX_AUCTION_PRD_SEACH ON AUCTION
(
	PRD_NM,
	TYPE_CD,
	PRD_TYPE_CD
)
;



CREATE UNIQUE INDEX IDX_START_END_DATE ON AUCTION
(
	START_DATE,
	END_DATE,
	PRD_NM
)
;



CREATE TABLE BID
(
	USR_NO                INTEGER NOT NULL,
	AUCTION_REG_NO        INTEGER NOT NULL,
	BID_DATE              DATE NOT NULL,
	BID_QTY               INTEGER NOT NULL,
	BID_NO                INTEGER NULL,
	 PRIMARY KEY (BID_NO)FOREIGN KEY R_19 (USR_NO) REFERENCES USR(USR_NO),
	FOREIGN KEY R_21 (AUCTION_REG_NO) REFERENCES AUCTION(REG_NO)
)
;



CREATE UNIQUE INDEX IDX_BID_PK ON BID
(
	BID_NO
)
;



CREATE UNIQUE INDEX IDX_BID_DATE ON BID
(
	BID_DATE
)
;



CREATE TABLE PR_BIDDING_HIST
(
	USR_NO                INTEGER NOT NULL,
	BID_NO                INTEGER NOT NULL,
	BID_DATE              DATE NOT NULL,
	BID_QTY               INTEGER NOT NULL,
	SBID_STAT             CHAR(1) NOT NULL,
	 PRIMARY KEY (USR_NO,BID_NO)FOREIGN KEY R_48 (USR_NO) REFERENCES USR(USR_NO),
	FOREIGN KEY R_50 (BID_NO) REFERENCES BID(BID_NO)
)
;



CREATE UNIQUE INDEX XPK������������ ON PR_BIDDING_HIST
(
	USR_NO,
	BID_NO
)
;



CREATE TABLE WALLET
(
	MONEY                 INTEGER NOT NULL,
	USR_NO                INTEGER NOT NULL,
	 PRIMARY KEY (USR_NO)FOREIGN KEY R_47 (USR_NO) REFERENCES USR(USR_NO)
)
;



CREATE UNIQUE INDEX IDX_WALLET_PK ON WALLET
(
	USR_NO
)
;



CREATE TABLE AUCTION_FILE
(
	FILE_NO               CHAR(18) NULL,
	FILE_NM               CHAR(18) NULL,
	FILE_PATH             CHAR(18) NULL,
	REG_NO                CHAR(18) NOT NULL,
	 PRIMARY KEY (FILE_NO)FOREIGN KEY R_58 (REG_NO) REFERENCES AUCTION(REG_NO)
)
;



CREATE UNIQUE INDEX XPK���÷������ ON AUCTION_FILE
(
	FILE_NO
)
;



CREATE TABLE COMMENT
(
	USR_NO                INTEGER NOT NULL,
	AUCTION_REG_NO        INTEGER NOT NULL,
	CMT_NO                INTEGER NULL,
	WRT_DATE              DATE NULL,
	WRT_CONT              VARCHAR(200) NULL,
	 PRIMARY KEY (CMT_NO)FOREIGN KEY R_41 (USR_NO) REFERENCES USR(USR_NO),
	FOREIGN KEY R_43 (AUCTION_REG_NO) REFERENCES AUCTION(REG_NO)
)
;



CREATE UNIQUE INDEX XPK������ȯ ON COMMENT
(
	CMT_NO
)
;



CREATE TABLE CHARGE
(
	AUCTION_REG_NO        INTEGER NOT NULL,
	CHG_NO                INTEGER NULL,
	CHG_DATE              DATE NOT NULL,
	TOTAL_CHG_PRICE       INTEGER NOT NULL,
	NOTE                  VARCHAR(200) NULL,
	 PRIMARY KEY (CHG_NO)FOREIGN KEY R_37 (AUCTION_REG_NO) REFERENCES AUCTION(REG_NO)
)
;



CREATE UNIQUE INDEX IDX_CHARGE_PK ON CHARGE
(
	CHG_NO
)
;



CREATE TABLE REG_BID_PRICE
(
	BID_NO                INTEGER NOT NULL,
	REG_BID_NO            INTEGER NULL,
	REG_BID_DATE          DATE NOT NULL,
	REG_BID_PRICE         INTEGER NOT NULL,
	 PRIMARY KEY (REG_BID_NO)FOREIGN KEY R_29 (BID_NO) REFERENCES BID(BID_NO)
)
;



CREATE UNIQUE INDEX IDX_REG_BID_PK ON REG_BID_PRICE
(
	REG_BID_NO
)
;



CREATE TABLE SBID
(
	SBID_STAT             CHAR(1) NOT NULL,
	REG_BID_NO            INTEGER NOT NULL,
	 PRIMARY KEY (REG_BID_NO)FOREIGN KEY R_30 (REG_BID_NO) REFERENCES REG_BID_PRICE(REG_BID_NO)
)
;



CREATE UNIQUE INDEX IDX_SBID_PK ON SBID
(
	REG_BID_NO
)
;



CREATE TABLE CHARGE_DETAIL
(
	CHG_NO                INTEGER NOT NULL,
	REG_BID_NO            INTEGER NOT NULL,
	CHG_PRICE             INTEGER NOT NULL,
	CHG_DATE              DATE NOT NULL,
	 PRIMARY KEY (CHG_NO,REG_BID_NO)FOREIGN KEY R_38 (CHG_NO) REFERENCES CHARGE(CHG_NO),
	FOREIGN KEY R_40 (REG_BID_NO) REFERENCES SBID(REG_BID_NO)
)
;



CREATE UNIQUE INDEX IDX_CHARGE_DETAIL_PK ON CHARGE_DETAIL
(
	CHG_NO,
	REG_BID_NO
)
;



CREATE TABLE DELIVERY
(
	DELI_NO               INTEGER NULL,
	DELI_DATE             DATE NOT NULL,
	NOTE                  VARCHAR(200) NULL,
	REG_BID_NO            INTEGER NOT NULL,
	DELI_METH             CHAR(1) NOT NULL,
	 PRIMARY KEY (DELI_NO)FOREIGN KEY R_24 (REG_BID_NO) REFERENCES SBID(REG_BID_NO)
)
;



CREATE UNIQUE INDEX IDX_DELIVERY_PK ON DELIVERY
(
	DELI_NO
)
;



CREATE TABLE RECEIVE
(
	DELI_NO               INTEGER NOT NULL,
	RECV_DATE             DATE NOT NULL,
	RECV_STAT             CHAR(1) NOT NULL,
	 PRIMARY KEY (DELI_NO)FOREIGN KEY R_34 (DELI_NO) REFERENCES DELIVERY(DELI_NO)
)
;



CREATE UNIQUE INDEX IDX_RECV_PK ON RECEIVE
(
	DELI_NO
)
;



CREATE TABLE RECV_RJT
(
	DELI_NO               INTEGER NOT NULL,
	RJT_REASON            VARCHAR(200) NOT NULL,
	RJT_DATE              DATE NOT NULL,
	RJT_METH              CHAR(1) NOT NULL,
	 PRIMARY KEY (DELI_NO)FOREIGN KEY R_35 (DELI_NO) REFERENCES RECEIVE(DELI_NO)
)
;



CREATE UNIQUE INDEX IDX_RECV_RJT_PK ON RECV_RJT
(
	DELI_NO
)
;



CREATE TABLE DELI_DETAIL
(
	DELI_COST             INTEGER NOT NULL,
	DELI_NO               INTEGER NOT NULL,
	DELI_LOC_CD           CHAR(1) NOT NULL,
	 PRIMARY KEY (DELI_NO)FOREIGN KEY R_32 (DELI_NO) REFERENCES DELIVERY(DELI_NO)
)
;



CREATE UNIQUE INDEX IDX_DELI_PK ON DELI_DETAIL
(
	DELI_NO
)
;



CREATE TABLE DELI_INFO
(
	ZIPNO                 CHAR(6) NOT NULL,
	ADDRESS               VARCHAR(200) NOT NULL,
	RECV_NM               VARCHAR(10) NOT NULL,
	TELNO                 VARCHAR(13) NOT NULL,
	DELI_NO               INTEGER NOT NULL,
	 PRIMARY KEY (DELI_NO)FOREIGN KEY R_33 (DELI_NO) REFERENCES DELI_DETAIL(DELI_NO)
)
;



CREATE UNIQUE INDEX IDX_DELI_INFO_PK ON DELI_INFO
(
	DELI_NO
)
;



CREATE TABLE PAYMENT
(
	PAY_NO                INTEGER NULL,
	PAY_DATE              DATE NOT NULL,
	REG_BID_NO            INTEGER NOT NULL,
	PAY_METH              CHAR(1) NOT NULL,
	PAY_PRICE             INTEGER NOT NULL,
	 PRIMARY KEY (PAY_NO)FOREIGN KEY R_23 (REG_BID_NO) REFERENCES SBID(REG_BID_NO)
)
;



CREATE UNIQUE INDEX IDX_PAYMENT_PK ON PAYMENT
(
	PAY_NO
)
;



CREATE TABLE PR_USR
(
	USR_NO                INTEGER NOT NULL,
	NM                    VARCHAR(10) NOT NULL,
	SOCIAL_NO             VARCHAR(14) NOT NULL,
	 PRIMARY KEY (USR_NO)FOREIGN KEY R_13 (USR_NO) REFERENCES USR(USR_NO)
)
;



CREATE UNIQUE INDEX IDX_USR_PK ON PR_USR
(
	USR_NO
)
;



CREATE UNIQUE INDEX IDX_USR_NM ON PR_USR
(
	NM
)
;



CREATE TABLE COM_USR
(
	USR_NO                INTEGER NOT NULL,
	COM_NM                CHAR(18) NOT NULL,
	BUS_NO                CHAR(18) NOT NULL,
	CEO_NM                VARCHAR(10) NOT NULL,
	CHG_NM                VARCHAR(10) NOT NULL,
	 PRIMARY KEY (USR_NO)FOREIGN KEY R_12 (USR_NO) REFERENCES USR(USR_NO)
)
;



CREATE UNIQUE INDEX IDX_COM_USR_PK ON COM_USR
(
	USR_NO
)
;



CREATE UNIQUE INDEX IDX_COM_USR_NM ON COM_USR
(
	COM_NM
)
;



CREATE TABLE BOARD
(
	BOARD_NO              CHAR(18) NULL,
	HIGH_BOARD_NO         CHAR(18) NULL,
	CONT                  CHAR(18) NULL,
	USERID                CHAR(18) NULL,
	REVIEW_CNT            CHAR(18) NULL,
	TITLE                 VARCHAR(50) NULL,
	 PRIMARY KEY (BOARD_NO)FOREIGN KEY R_54 (BOARD_NO) REFERENCES BOARD(BOARD_NO)
)
;



CREATE UNIQUE INDEX XPK�������� ON BOARD
(
	BOARD_NO
)
;

