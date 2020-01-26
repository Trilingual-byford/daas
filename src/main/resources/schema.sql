
create table inu (id bigint not null, dir varchar(255), gender integer, height integer, likes bigint, pic_size bigint, width integer, primary key (id))
create table inu_attribution (inu_id bigint not null, attribution varchar(255))
-- CREATE TABLE inu_attribution (inu_id bigint not null,attribution varchar(255))
-- CREATE TABLE inu(
--     id bigint PRIMARY KEY AUTO_INCREMENT,
--     dir varchar(255),
--     gender integer ,
--     height integer ,
--     likes bigint,
--     pic_size bigint,
--     width integer,
-- )
alter table inu_attribution add constraint FKlyf4slpxp19vay0gan2ei3rdq foreign key (inu_id) references inu