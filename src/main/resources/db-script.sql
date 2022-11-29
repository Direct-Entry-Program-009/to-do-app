CREATE TABLE U



CREATE TABLE todo_item(
                          id INT AUTO_INCREMENT PRIMARY KEY ,
                          user_name VARCHAR(50) NOT NULL ,
                          description VARCHAR(100) NOT NULL ,
                          status ENUM('DONE', 'NOT DONE'),
                          CONSTRAINT FOREIGN KEY (user_name) REFERENCES user(user_name)
);