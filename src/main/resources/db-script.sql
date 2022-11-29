CREATE TABLE user
(
    user_name VARCHAR(200) PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    password VARCHAR(250) NOT NULL
);



CREATE TABLE todo_item(
                          id INT AUTO_INCREMENT PRIMARY KEY ,
                          user_name VARCHAR(50) NOT NULL ,
                          description VARCHAR(100) NOT NULL ,
                          status ENUM('DONE', 'NOT DONE'),
                          CONSTRAINT FOREIGN KEY (user_name) REFERENCES user(user_name)
);