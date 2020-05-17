INSERT INTO 
	users (mob_nmbr, passwrd, role) 
VALUES
  	(1234567890, 'adsecret', 'admin'),
  	(1234567891, 'consecret', 'consumer'),
  	(1234567892, 'mersecret', 'merchant');

INSERT INTO 
	vouchers (voucher_code, amount, start_dt, end_dt)
VALUES
  	('test_1', 100,'2020-01-01','2020-01-31'),
  	('test_2', 200,'2019-01-01','2020-01-31'),
  	('test_3', 300,'2019-01-01','2019-01-31'),
  	('test_4', 400,'2020-01-01','2020-01-31'),
  	('test_5', 500,'2020-01-01','2020-01-31')