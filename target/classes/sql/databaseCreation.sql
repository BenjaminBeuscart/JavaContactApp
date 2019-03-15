CREATE TABLE `person` ( `idperson` INT NOT NULL AUTO_INCREMENT, `lastname` VARCHAR(45) NOT NULL, `firstname` VARCHAR(45) NOT NULL, `nickname` VARCHAR(45) NOT NULL, `phone_number` VARCHAR(15) NULL, `address` VARCHAR(200) NULL, `email_address` VARCHAR(150) NULL, `birth_date` DATE NULL, PRIMARY KEY (`idperson`));
INSERT INTO `person` (`lastname`, `firstname`, `nickname`, `phone_number`, `address`, `email_address`, `birth_date`) VALUES
('Gille', 'Paul', 'Paulo', '0689259123', '52 rue de la baille 59242 Templeuve', 'paul.gille@isen.yncrea.fr', '1997-06-06'),
('Beuscart', 'Benjamin', 'Ben', '0628399449', '60 rue de la fauconiere 59000 Lille', 'benjamin.beuscart@isen.yncrea.fr', '1996-09-02'),
('Beghin', 'Clement', 'Clem', '0628399103', '52 rue nationale 59280 Armentieres', 'clement.beghin@gmail.com', '1998-01-02');
