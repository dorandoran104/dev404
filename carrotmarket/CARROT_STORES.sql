create table CARROT_STORES(
  bno number(10,0),
  notice varchar2(200),
  content varchar2(3000) not null,
  customBenefit varchar2(300),
  StoresLocation varchar2(300),
  writer varchar2(150),
  regdate date default sysdate, 
  updatedate date default sysdate
);

--?? μ¦κ? ????€ λ§λ€κΈ?
CREATE SEQUENCE seq_carrot_stores START WITH 1 INCREMENT BY 1;

--bnoλ₯? pkλ‘? λ§λ¦
alter table carrot_stores add constraint pk_carrot_stores primary key (bno);

--?°?΄?° ?½? ??€?Έ
insert into carrot_stores (bno, notice, content, customBenefit,StoresLocation, writer) 
values (seq_carrot_stores.nextval, 'TestNotice', '??€?Έ λ³Έλ¬Έ ?΄?©', ' λ² λ€?', 'κ°?κ²? ?μΉ?', '??±?');

commit;


