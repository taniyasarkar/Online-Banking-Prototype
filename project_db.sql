create table account_type
(type_id varchar2(6) Primary Key,
type_name varchar2(10),
remarks varchar2(100)
)






create table user_details
(accnt_no number PRIMARY KEY,
cid varchar2(20) check(cid like 'STS%'),
f_name varchar2(20),
l_name varchar2(30),
date_of_birth date,
address varchar2(50),
mob varchar2(15),
email varchar2(50), 
photo blob,
ref_account number,
account_type varchar2(10),
password varchar2(30));





create table user_reg
(reg_id number PRIMARY KEY,
f_name varchar2(20),
l_name varchar2(30),
date_of_birth date,
address varchar2(50),
mob varchar2(15),
email varchar2(50), 
photo blob,
ref_account number REFERENCES user_details,
accnt_type varchar2(10) references account_type,
password varchar2(30));




create table transaction
(trnsc_id number PRIMARY KEY,
trnsc_date date,
debt_accnt number,
credit_accnt number,
amnt number,
method varchar2(20),
remarks varchar2(100)
);

create table card
(card_number number PRIMARY KEY,
card_type varchar2(20),
card_status varchar2(20),
card_holder number,
card_issue_date date,
remarks varchar2(100));


create table check_book
(check_book_id number PRIMARY KEY,
start_number number,
last_number number,
type varchar2(20),
accnt_number number,
issue_date date,
leafs number);

create table loan
(loan_type varchar2(20),
loan_id number PRIMARY KEY,
interest_rate number,
time_period varchar2(10),
scheme varchar2(100));



create table bank_staff
(emp_id varchar2(6) PRIMARY KEY,
name varchar2(20),
user_name varchar2(20),
password varchar2(30))





insert into user_details(accnt_no, cid, f_name, l_name, date_of_birth, address, mob, email, ref_account, account_type, password)
values(5, 'STS05', 'fjjgk', 'jgkjg', TO_DATE('20/08/1997','DD/MM/YYYY'), 'kolkata', '45878438', 'rockingprogrammer@rediffmail.com', 1, 'Gen01', 'password')