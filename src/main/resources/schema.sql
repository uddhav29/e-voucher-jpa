DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vouchers;
DROP TABLE IF EXISTS voucher_asgnmnt;
 
CREATE TABLE users (
  user_id INT AUTO_INCREMENT  PRIMARY KEY,
  mob_nmbr INT(10) NOT NULL,
  passwrd VARCHAR(250) NOT NULL,
  role VARCHAR(250) DEFAULT NULL
);

CREATE TABLE vouchers (
  voucher_id INT AUTO_INCREMENT  PRIMARY KEY,
  voucher_code VARCHAR(250) NOT NULL,
  amount DOUBLE NOT NULL,
  start_dt DATE NOT NULL,
   redeem_flg BOOLEAN DEFAULT FALSE,
  end_dt DATE NOT NULL
  isgrp
  fk UUID
);

CREATE TABLE voucher_asgnmnt (
  voucher_asg_id INT AUTO_INCREMENT  PRIMARY KEY,
  voucher_id INT NOT NULL,
  mob_nmbr INT(10) NOT NULL,
  CONSTRAINT FK_asgnmnt_voucher FOREIGN KEY (voucher_id) REFERENCES vouchers(voucher_id),
  CONSTRAINT FK_mob_user FOREIGN KEY (mob_nmbr) REFERENCES users(mob_nmbr)
);
