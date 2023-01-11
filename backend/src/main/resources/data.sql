INSERT INTO tb_user ( name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user ( name, email, password) VALUES ('Bob Brow', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user ( name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Bootcamp HTML','https://www.publicdomainpictures.net/pictures/270000/nahled/training-course-training-online.jpg','https://vle.btvi.edu.bs/moodle/pluginfile.php/101066/course/overviewfiles/HTML-00-CourseImage.jpg');
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-09-14T03:00:00Z',TIMESTAMP WITH TIME ZONE '2023-09-14T03:00:00Z',1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2022-12-14T03:00:00Z',TIMESTAMP WITH TIME ZONE '2023-12-14T03:00:00Z',1);


INSERT INTO tb_resource (title, description,position,img_Uri,type,offer_id) VALUES ('Trilha HTML','Trilha Principal do curso',1,'https://openclipart.org/image/800px/69331',1,1);
INSERT INTO tb_resource (title, description,position,img_Uri,type,offer_id) VALUES ('Fórum','Tire suas dúvidas',2,'https://openclipart.org/image/800px/69331',2,1);
INSERT INTO tb_resource (title, description,position,img_Uri,type,offer_id) VALUES ('Lives','Lives exclusivas para a turma',3,'https://openclipart.org/image/800px/69331',0,1);

INSERT INTO tb_section (title, description,position,img_Uri,resource_id, prerequisite_id) VALUES ('Capítulo 01','Neste capítulo vamos começar...',1,'https://openclipart.org/image/800px/69331',1,null );
INSERT INTO tb_section (title, description,position,img_Uri,resource_id, prerequisite_id) VALUES ('Capítulo 02','Neste capítulo vamos continuar...',2,'https://openclipart.org/image/800px/69331',1,1 );
INSERT INTO tb_section (title, description,position,img_Uri,resource_id, prerequisite_id) VALUES ('Capítulo 03','Neste capítulo vamos finalizar...',3,'https://openclipart.org/image/800px/69331',1,2 );

INSERT INTO tb_enrollment (user_id, offer_id,enroll_Moment,refund_Moment, available, only_Update) VALUES (1, 1,TIMESTAMP WITH TIME ZONE '2022-09-14T13:00:00Z',null,true,false);
INSERT INTO tb_enrollment (user_id, offer_id,enroll_Moment,refund_Moment, available, only_Update) VALUES (2, 1,TIMESTAMP WITH TIME ZONE '2022-09-15T15:00:00Z',null,true,false);