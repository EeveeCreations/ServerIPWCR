--product
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy Figure','Its a nice Figure of Lufy',30.50,'figure,luffy','luffy_figure.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy Hat','Now ypu can be come oen of teh strawhat Piretes',22.95,'hat,luffy','luffy_hat.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Nami Figure','She wont slap you. For Now',30.50,'figure,nami','nami_figure.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Nami T-shirt',' Dont tusch ma growin boobs',26.96,'shirt,nami','nami_shirt.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Zorro Figure','Its a nice Figure of Zorro',30.50,'figure,zorro','zorro_figure.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Zorro Sword',' its the white one but also the real one!',325.0,'other,zorro','zorro_sword.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Usapp Figure','Lookin Awsome as Always',30.50,'figure,ussop','ussop_figure.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Ussop T-shirt','Ussop on a shirt, Your nwo just as Cool as him',26.96,'shirt,ussop','ussop_shirt.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Ussop Hat',' WOOWW Ussops Fenomianal HAt',22.95,'hat,ussop','ussop_hat.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Chopper Hat','Choppers HAt now All Yours',22.95,'hat,chopper','chopper_hat.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Chopper KeyChain','Copper on a KeyChain',5.50,'keychain,chopper','chopper_keychain.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy T-shirt','Its a nice T-shirt of Luffy',26.96,'shirt,luffy','luffy_shirt.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Sanji T-shirt','Its a nice T-shirt of Sanji',26.96,'shirt,sanji','sanji_shirt.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Sanji Rose','Sanjis iconic rose',12.50,'other,sanji','sanji_rose.jpg');

-- Storage
INSERT INTO storage(product_nr,amount,sold_out) VALUES(31,30,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(32,34,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(33,51,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(34,20,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(35,33,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(36,20,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(37,53,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(38,0,true);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(39,34,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(40,42,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(41,54,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(42,12,false);
INSERT INTO storage(product_nr,amount,sold_out) VALUES(43,23,false);

--Cart

--Order

--user
INSERT INTO user(id,name,passcode,admin) VALUES(1,'Eevee','7004',true);
