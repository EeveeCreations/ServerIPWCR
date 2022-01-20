--product
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy Figure','Its a nice Figure of Lufy',30.50,'figure,luffy','https://www.impericon.com/432x624x90/media/catalog/product/a/b/abyfig008_lg.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy Hat','Now ypu can be come oen of teh strawhat Piretes',22.95,'hat,luffy','https://m.media-amazon.com/images/I/61+5hBQrXHL._AC_UX679_.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Nami Figure','She wont slap you. For Now',30.50,'figure,nami','https://yugen-collectibles.com/12177-large_default/one-piece-portrait-of-pirates-playback-memories-nami.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Nami T-shirt',' Dont tusch ma growin boobs',26.96,'shirt,nami','https://ih1.redbubble.net/image.295971285.1061/ssrco,slim_fit_t_shirt,mens,101010:01c5ca27c6,front,square_product,600x600.u1.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Zorro Figure','Its a nice Figure of Zorro',30.50,'figure,zorro','https://onepiece-store.com/wp-content/uploads/2021/07/hot-one-piece-roronoa-zoro-figure-combat-ver-329.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Zorro Sword',' its the white one but also the real one!',325.0,'other,zorro','https://media.karousell.com/media/photos/products/2019/09/04/one_piece_roronoa_zoro_swords__cosplay_wooden_sword__1567606684_d2a443a20');
INSERT INTO product(name,description,price,category,image_path) VALUES('Usapp Figure','Lookin Awesome as Always',30.50,'figure,ussop','https://images.stockx.com/images/Banpresto-One-Piece-World-Colosseum-2-Volume-1-Usopp-Figure-Tan.jpg?fit=fill&bg=FFFFFF&w=480&h=320&auto=compress&q=90&dpr=2&trim=color&updated_at=1633462280&fm=webp');
INSERT INTO product(name,description,price,category,image_path) VALUES('Ussop T-shirt','Ussop on a shirt, Your nwo just as Cool as him',26.96,'shirt,ussop','https://res.cloudinary.com/teepublic/image/private/s--nfaZwGS0--/t_Resized%20Artwork/c_crop,x_10,y_10/c_fit,h_626/c_crop,g_north_west,h_626,w_470,x_-46,y_-60/g_north_west,u_upload:v1462829015:production:blanks:mtl53ofohwq5goqjo9ke,x_-441,y_-385/b_rgb:eeeeee/c_limit,f_auto,h_630,q_90,w_630/v1557491100/production/designs/4809497_0.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Ussop Hat',' WOOWW Ussops Fenomianal HAt',22.95,'hat,ussop','https://ae01.alicdn.com/kf/HTB1QXdjLpXXXXchXpXXq6xXFXXXM/usopp-hat-for-adults-halloween-pirate-hat-pirate-cap-party-hat-funny-hat-for-adults-.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Chopper Hat','Choppers HAt now All Yours',22.95,'hat,chopper','https://m.media-amazon.com/images/I/514ffOR20SL._AC_SX450_.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Chopper KeyChain','Copper on a KeyChain',5.50,'keychain,chopper','https://media.s-bol.com/736AAJGX17QG/550x436.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Luffy T-shirt','Its a nice T-shirt of Luffy',26.96,'shirt,luffy','https://res.cloudinary.com/teepublic/image/private/s--WCGO80JS--/t_Resized%20Artwork/c_crop,x_10,y_10/c_fit,h_626/c_crop,g_north_west,h_626,w_470,x_-13,y_0/g_north_west,u_upload:v1462829015:production:blanks:mtl53ofohwq5goqjo9ke,x_-408,y_-325/b_rgb:eeeeee/c_limit,f_auto,h_630,q_90,w_630/v1569998725/production/designs/6173610_0.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Sanji T-shirt','Its a nice T-shirt of Sanji',26.96,'shirt,sanji','https://res.cloudinary.com/teepublic/image/private/s--8tMaKIwW--/t_Resized%20Artwork/c_crop,x_10,y_10/c_fit,w_658/c_crop,g_north_west,h_626,w_470,x_-6,y_0/g_north_west,u_upload:v1462829024:production:blanks:a59x1cgomgu5lprfjlmi,x_-401,y_-325/b_rgb:eeeeee/c_limit,f_auto,h_630,q_90,w_630/v1528726440/production/designs/2777109_0.jpg');
INSERT INTO product(name,description,price,category,image_path) VALUES('Sanji Rose','Sanjis iconic rose',12.50,'other,sanji','https://sc04.alicdn.com/kf/UTB8jh1IJiaMiuJk43PTq6ySmXXan.jpg');

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

--cartItems
INSERT INTO cart_item(amount,cart_cart_nr,product_product_nr) VALUES(1,1,46);
INSERT INTO cart_item(amount,cart_cart_nr,product_product_nr) VALUES(1,1,43);


--Cart
INSERT INTO cart(amount_of_products,total_price,ordered) VALUES(1,35,false);

--Order
INSERT INTO public.order(completed,cart) VALUES(false,1);

--webUser
INSERT INTO webUser(id,name,passcode,admin) VALUES(1,'Eevee','7004',true);
