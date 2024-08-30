create table if not exists users(
                                    user_id SERIAL NOT NULL  PRIMARY KEY,
                                    password varchar(100) Not NUll,
    username varchar(100) Not NUll,
    email varchar(100) Not NUll,
    role varchar(100)  NUll,
    enabled Boolean  NUll,
    time date null
    );
create table if not exists comment(
                                      comment_id SERIAL not null  primary key,
                                      content varchar(100) null,
    score bigint null,
    date date null,
    user_id bigint null ,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
    );