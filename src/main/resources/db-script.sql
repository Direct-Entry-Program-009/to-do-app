CREATE TABLE `user`
(
    `user_name` VARCHAR(200) PRIMARY KEY,
    `full_name` VARCHAR(150) NOT NULL,
    `password` VARCHAR(250) NOT NULL
);



CREATE TABLE `todo_item`(
                          `id` INT AUTO_INCREMENT PRIMARY KEY ,
                          `user_name` VARCHAR(200) NOT NULL ,
                          `description` VARCHAR(100) NOT NULL ,
                          `status` ENUM('DONE', 'NOT_DONE'),
                          CONSTRAINT `fk_user` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
);

INSERT INTO `user` (`user_name`, `full_name`, `password`) VALUES
                                ('visal', 'visal srimanga', 'test'),
                                ('srimanga', 'visal srimanga', 'test2');

INSERT INTO `todo_item` (`user_name`, `description`, `status`) VALUES
                                ('visal', 'test', 'DONE'),
                                ('srimanga', 'test', 'DONE')