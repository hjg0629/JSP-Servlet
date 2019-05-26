create table matches(
   seqNo int not null, <- (Auto IncreaseMent)
    seqDate timestamp not null default now(),
   flag1 int not null,
   flag2 varchar(20) not null,
   title varchar(55) not null,
   stime timestamp not null default now(),
   etime timestamp not null  default now(),
   contents varchar(500) not null,
   addr varchar(200) not null,
    teamflag int not null,
    needman int not null,
    nowman int default 0,
    primary key(seqNo)
);

alter table matches convert to charset euckr;