<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
Member userId,userPwd,userName,userMsg,userDate,userType
board bNum,bWriter,bTitle,bContents,bDate
reply rNum,rWriter,rTitle,rContent,rDate,rBoardNum

member- insert,select,delete,selectAll,login,logout
board - insert,select,del,selectAll
reply - insert,select,del,selectAll

create table j_member(
userId varchar2(200) primary key,
userPwd varchar2(200) not null,
userName varchar2(200) not null,
userMsg varchar2(200) not null,
userDate date ,
userType number not null);

create table j_board(
bNum number primary key,
bWriter varchar2(200) not null,
bTitle varchar2(200) not null,
bContents varchar2(200) not null,
bDate date);
create sequence j_board_seq;

create table j_reply(
rNum number primary key,
rwriter varchar2(200) not null,
rtitle varchar2(200) not null,
rContent varchar2(200) not null,
rdate date,
rboardnum number not null);
create sequence j_reply_seq;

 -->