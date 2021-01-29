DELETE FROM movie_sec_actors;
DELETE FROM review;
DELETE FROM app_user;
DELETE FROM movie;
DELETE FROM actor;

INSERT INTO actor(LAST_NAME, FIRST_NAME) VALUES
  ("L'éclair", "Buzz"),(NULL, "Woody"),(NULL, "Jessie"),("Robinson", "Leon"),("Candy", "John"),("Yoba", "Malik"),
  ("Gibson", "Mel"),("Marceau", "Sophie"),("Moore", "Roger"),("Lonsdale", "Michael");

INSERT INTO movie (TITLE,GENRE,DESCRIPTION,ID_MAIN_ACTOR) VALUES
  ('Toys Story 3','ANIMATION',"Les créateurs des très populaires films Toy Story ouvrent à nouveau le coffre à jouets et invitent les spectateurs à retrouver le monde délicieusement magique de Woody et Buzz au moment où Andy s'apprête à partir pour l'université.",(select ID from actor where FIRST_NAME="Buzz")),
  ('Rasta Rocket','COMEDIE',"Comment une équipe de la Jamaïque, après de multiples aventures, va participer à l'épreuve de bobsleigh à quatre aux Jeux Olympiques d'hiver de Calgary.",(select ID from actor where FIRST_NAME="Leon")),
  ('Braveheart','DRAME',"Edouard Ier, roi d'Angleterre, s'empare du trône après avoir réglé un conflit avec le personnage fantoche qu'il y avait auparavant placé. William Wallace prend la tête d'une révolte paysanne.",(select ID from actor where FIRST_NAME="Mel")),
  ('Moonraker','THRILLER',"L'agent secret britannique James Bond enquête sur la disparition d'une navette spatiale americaine, Moonraker, confiee au gouvernement britannique. 007 se rend aux Etats-Unis pour interroger le responsable de la construction de la navette, Sir Hugo Drax.",(select ID from actor where FIRST_NAME="Roger"));


INSERT INTO movie_sec_actors(ID_MOVIE, ID_ACTOR) VALUES
  ((select ID from movie where TITLE="Toys Story 3"),(select ID from actor where FIRST_NAME="Woody")),
  ((select ID from movie where TITLE="Toys Story 3"),(select ID from actor where FIRST_NAME="Jessie")),
  ((select ID from movie where TITLE="Rasta Rocket"),(select ID from actor where FIRST_NAME="John")),
  ((select ID from movie where TITLE="Rasta Rocket"),(select ID from actor where FIRST_NAME="Malik")),
  ((select ID from movie where TITLE="Braveheart"),(select ID from actor where FIRST_NAME="Sophie")),
  ((select ID from movie where TITLE="Moonraker"),(select ID from actor where FIRST_NAME="Michael"));

INSERT INTO app_user (USERNAME) VALUES ('John Doe'),('Tom Pike'),('Elton James'),('Bobby Wing');

INSERT INTO review (ID_MOVIE,ID_REVIEWER,MARK,REVIEW_COMMENT) VALUES
  ((select ID from movie where TITLE="Toys Story 3"),(select ID from app_user where USERNAME='John Doe'),2,"Franchement ce film est pas terrible"),
  ((select ID from movie where TITLE="Toys Story 3"),(select ID from app_user where USERNAME='Tom Pike'),5,"Super cool pour les enfants !"),
  ((select ID from movie where TITLE="Toys Story 3"),(select ID from app_user where USERNAME='Elton James'),5,NULL),
  ((select ID from movie where TITLE="Rasta Rocket"),(select ID from app_user where USERNAME='John Doe'),4,"J'ai bien rigolé"),
  ((select ID from movie where TITLE="Rasta Rocket"),(select ID from app_user where USERNAME='Tom Pike'),3,NULL),
  ((select ID from movie where TITLE="Braveheart"),(select ID from app_user where USERNAME='Elton James'),1,"Ce film est trop violent pour moi."),
  ((select ID from movie where TITLE="Moonraker"),(select ID from app_user where USERNAME='Bobby Wing'),5,NULL),
  ((select ID from movie where TITLE="Moonraker"),(select ID from app_user where USERNAME='Tom Pike'),4,"Ca c'est du cinéma");