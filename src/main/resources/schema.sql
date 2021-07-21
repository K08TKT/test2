CREATE TABLE IF NOT EXISTS employee(
 employee_id INT PRIMARY KEY,
 employee_name VARCHAR(50),
 age INT
);

CREATE TABLE IF NOT EXISTS m_pc(
 name VARCHAR(50)
 ,os VARCHAR(50)
 ,cpu VARCHAR(50)
 ,ghz NUMERIC
 ,gpu VARCHAR(50)
 ,ram INT
 ,hddCapa INT
 ,byt VARCHAR(50)
 ,ssdCapa INT
 ,byt2 VARCHAR(50)
 ,eth CHAR
 ,strWifi VARCHAR(50)
 ,resolution VARCHAR(50)
 ,lcd NUMERIC
 ,manufacturers VARCHAR(50)
 ,release VARCHAR(50)
 ,description VARCHAR(100)
);