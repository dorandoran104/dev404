create table CARROT_STORES_IMAGES (
  bno number(10,0),
  uuid varchar2(200) not null,
  uploadPath varchar2(200) not null,
  fileName varchar2(100) not null, 
  filetype char(1) default 'I'
);


--PKλ‘? UUID μ§?? 
alter table CARROT_STORES_IMAGES add constraint PK_CARROT_STORES_IMAGES primary key (uuid);

--FK(?Έ??€)λ‘? κ²μ?(CARROT_STORES) μ§?? 
alter table CARROT_STORES_IMAGES add constraint FK_CARROT_STORES_IMAGES foreign key (bno) references CARROT_STORES(bno);


commit;


SELECT id, uuid, uploadpath, filename
FROM carrot_member
WHERE uuid IS NOT NULL AND uploadpath IS NOT NULL AND filename IS NOT NULL;



















--?°?΄?° ?½? ??€?Έ
INSERT INTO CARROT_STORES_IMAGES (bno,uuid, uploadPath, fileName, filetype)
VALUES ('1', 'uuidTest', '/uploadPath/test','TestfileName','I');


--xxxxxx????€ ?? μ¦κ? ?Έλ¦¬κ±° (κΈ°λ‘?© ?¬?©??¨!!) xxxxxxxx
CREATE OR REPLACE TRIGGER stores_image_trigger
BEFORE INSERT ON stores_image
FOR EACH ROW
BEGIN
   :NEW.image_id := CARROT_imageVO_seq.NEXTVAL;
END;

