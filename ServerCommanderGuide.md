### mysql  Ver 15.1 Distrib 5.5.64-MariaDB, for Linux (x86_64) using readline 5.1

### ServerCommanderGuide
### Login in:
##### ssh -p 1008 userbyford@38.109.217.119
### Mysql Login in:
##### mysql -u root -p
### Check Password List:
##### SELECT host, user, password FROM mysql.user;
### Change user password:
##### SET PASSWORD FOR ‘userDAAS2’@‘%’ = PASSWORD(‘daas’);
### Activate new password:
##### FLUSH PRIVILEGES;
### Create User:
##### CREATE USER 'daas'@'%' IDENTIFIED BY 'password'
### Grant user access:
##### GRANT ALL ON *.* TO 'lol'@'%' WITH GRANT OPTION;
