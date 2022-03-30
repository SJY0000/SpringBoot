CREATE TABLE IF NOT EXISTS user_accounts (
	# 유저아이디(자동생성), 유저네임(아이디), 이메일, 패스워드, 역할(일반, 관리자), enable(사용가능 계정 여부)
    user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    enabled BOOLEAN DEFAULT TRUE
);
SELECT * FROM pma.user_accounts;