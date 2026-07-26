INSERT INTO tbl_yield
(state, region, expected_yield, yield_unit, market_price,
price_unit, expected_income, expected_profit, crop_id)
VALUES

-- =====================================================
-- RICE (crop_id = 1)
-- =====================================================
('Uttar Pradesh','North India',55,'Quintal/Ha',2400,'INR/Quintal',132000,96000,1),
('Punjab','North India',60,'Quintal/Ha',2450,'INR/Quintal',147000,107400,1),
('West Bengal','East India',53,'Quintal/Ha',2350,'INR/Quintal',124550,91150,1),

-- =====================================================
-- MAIZE (crop_id = 2)
-- =====================================================
('Karnataka','South India',60,'Quintal/Ha',2100,'INR/Quintal',126000,96700,2),
('Bihar','East India',58,'Quintal/Ha',2050,'INR/Quintal',118900,90700,2),
('Madhya Pradesh','Central India',62,'Quintal/Ha',2120,'INR/Quintal',131440,101140,2),

-- =====================================================
-- CHICKPEA (crop_id = 3)
-- =====================================================
('Madhya Pradesh','Central India',22,'Quintal/Ha',6500,'INR/Quintal',143000,117700,3),
('Rajasthan','West India',21,'Quintal/Ha',6450,'INR/Quintal',135450,111450,3),
('Uttar Pradesh','North India',23,'Quintal/Ha',6550,'INR/Quintal',150650,124550,3),

-- =====================================================
-- KIDNEY BEANS (crop_id = 4)
-- =====================================================
('Himachal Pradesh','North India',20,'Quintal/Ha',7000,'INR/Quintal',140000,113000,4),
('Jammu & Kashmir','North India',21,'Quintal/Ha',7100,'INR/Quintal',149100,121000,4),
('Uttarakhand','North India',19,'Quintal/Ha',6950,'INR/Quintal',132050,105750,4),

-- =====================================================
-- PIGEON PEAS (crop_id = 5)
-- =====================================================
('Maharashtra','West India',18,'Quintal/Ha',7500,'INR/Quintal',135000,107100,5),
('Karnataka','South India',19,'Quintal/Ha',7450,'INR/Quintal',141550,112750,5),
('Telangana','South India',18,'Quintal/Ha',7550,'INR/Quintal',135900,107600,5),

-- =====================================================
-- MOTH BEANS (crop_id = 6)
-- =====================================================
('Rajasthan','West India',12,'Quintal/Ha',6500,'INR/Quintal',78000,58200,6),
('Gujarat','West India',13,'Quintal/Ha',6550,'INR/Quintal',85150,64550,6),
('Haryana','North India',12,'Quintal/Ha',6600,'INR/Quintal',79200,58000,6),

-- =====================================================
-- MUNG BEAN (crop_id = 7)
-- =====================================================
('Rajasthan','West India',15,'Quintal/Ha',7200,'INR/Quintal',108000,86200,7),
('Haryana','North India',16,'Quintal/Ha',7250,'INR/Quintal',116000,93400,7),
('Gujarat','West India',15,'Quintal/Ha',7150,'INR/Quintal',107250,85050,7),

-- =====================================================
-- BLACK GRAM (crop_id = 8)
-- =====================================================
('Uttar Pradesh','North India',16,'Quintal/Ha',7000,'INR/Quintal',112000,89200,8),
('Madhya Pradesh','Central India',17,'Quintal/Ha',7050,'INR/Quintal',119850,96250,8),
('Maharashtra','West India',16,'Quintal/Ha',7100,'INR/Quintal',113600,90400,8),

-- =====================================================
-- LENTIL (crop_id = 9)
-- =====================================================
('Madhya Pradesh','Central India',18,'Quintal/Ha',6800,'INR/Quintal',122400,99500,9),
('Uttar Pradesh','North India',19,'Quintal/Ha',6850,'INR/Quintal',130150,106450,9),
('Bihar','East India',18,'Quintal/Ha',6750,'INR/Quintal',121500,98200,9),

-- =====================================================
-- POMEGRANATE (crop_id = 10)
-- =====================================================
('Maharashtra','West India',180,'Quintal/Ha',3500,'INR/Quintal',630000,542000,10),
('Karnataka','South India',185,'Quintal/Ha',3550,'INR/Quintal',656750,565850,10),
('Gujarat','West India',178,'Quintal/Ha',3480,'INR/Quintal',619440,532640,10),

-- =====================================================
-- BANANA (crop_id = 11)
-- =====================================================
('Tamil Nadu','South India',650,'Quintal/Ha',1200,'INR/Quintal',780000,663000,11),
('Maharashtra','West India',640,'Quintal/Ha',1220,'INR/Quintal',780800,660900,11),
('Andhra Pradesh','South India',660,'Quintal/Ha',1190,'INR/Quintal',785400,671600,11),

-- =====================================================
-- MANGO (crop_id = 12)
-- =====================================================
('Uttar Pradesh','North India',120,'Quintal/Ha',3000,'INR/Quintal',360000,287000,12),
('Andhra Pradesh','South India',125,'Quintal/Ha',3050,'INR/Quintal',381250,305350,12),
('Karnataka','South India',122,'Quintal/Ha',3020,'INR/Quintal',368440,293940,12),

-- =====================================================
-- GRAPES (crop_id = 13)
-- =====================================================
('Maharashtra','West India',250,'Quintal/Ha',4000,'INR/Quintal',1000000,894000,13),
('Karnataka','South India',255,'Quintal/Ha',4050,'INR/Quintal',1032750,923850,13),
('Telangana','South India',248,'Quintal/Ha',3980,'INR/Quintal',987040,882240,13),

-- =====================================================
-- WATERMELON (crop_id = 14)
-- =====================================================
('Karnataka','South India',350,'Quintal/Ha',1400,'INR/Quintal',490000,447000,14),
('Andhra Pradesh','South India',360,'Quintal/Ha',1420,'INR/Quintal',511200,466700,14),
('Telangana','South India',345,'Quintal/Ha',1410,'INR/Quintal',486450,442750,14),

-- =====================================================
-- MUSKMELON (crop_id = 15)
-- =====================================================
('Punjab','North India',220,'Quintal/Ha',1800,'INR/Quintal',396000,355000,15),
('Haryana','North India',225,'Quintal/Ha',1820,'INR/Quintal',409500,367600,15),
('Rajasthan','West India',215,'Quintal/Ha',1780,'INR/Quintal',382700,342600,15),

-- =====================================================
-- APPLE (crop_id = 16)
-- =====================================================
('Himachal Pradesh','North India',180,'Quintal/Ha',4500,'INR/Quintal',810000,700000,16),
('Jammu & Kashmir','North India',185,'Quintal/Ha',4550,'INR/Quintal',841750,728850,16),
('Uttarakhand','North India',178,'Quintal/Ha',4480,'INR/Quintal',797440,688640,16),

-- =====================================================
-- ORANGE (crop_id = 17)
-- =====================================================
('Maharashtra','West India',220,'Quintal/Ha',2500,'INR/Quintal',550000,449500,17),
('Madhya Pradesh','Central India',215,'Quintal/Ha',2480,'INR/Quintal',533200,434700,17),
('Rajasthan','North India',210,'Quintal/Ha',2520,'INR/Quintal',529200,429300,17),

-- =====================================================
-- PAPAYA (crop_id = 18)
-- =====================================================
('Andhra Pradesh','South India',500,'Quintal/Ha',1500,'INR/Quintal',750000,679500,18),
('Gujarat','West India',490,'Quintal/Ha',1520,'INR/Quintal',744800,672400,18),
('Karnataka','South India',505,'Quintal/Ha',1490,'INR/Quintal',752450,682850,18),

-- =====================================================
-- COCONUT (crop_id = 19)
-- =====================================================
('Kerala','South India',12000,'Nuts/Ha',18,'INR/Nut',216000,131000,19),
('Tamil Nadu','South India',12200,'Nuts/Ha',18,'INR/Nut',219600,132600,19),
('Karnataka','South India',11800,'Nuts/Ha',19,'INR/Nut',224200,140300,19),

-- =====================================================
-- COTTON (crop_id = 20)
-- =====================================================
('Gujarat','West India',28,'Quintal/Ha',7200,'INR/Quintal',201600,150100,20),
('Maharashtra','West India',27,'Quintal/Ha',7300,'INR/Quintal',197100,144200,20),
('Telangana','South India',29,'Quintal/Ha',7250,'INR/Quintal',210250,158100,20),

-- =====================================================
-- JUTE (crop_id = 21)
-- =====================================================
('West Bengal','East India',32,'Quintal/Ha',5200,'INR/Quintal',166400,123900,21),
('Assam','North East India',31,'Quintal/Ha',5250,'INR/Quintal',162750,119350,21),
('Bihar','East India',30,'Quintal/Ha',5150,'INR/Quintal',154500,112800,21),

-- =====================================================
-- COFFEE (crop_id = 22)
-- =====================================================
('Karnataka','South India',20,'Quintal/Ha',30000,'INR/Quintal',600000,468000,22),
('Kerala','South India',19,'Quintal/Ha',30500,'INR/Quintal',579500,449800,22),
('Tamil Nadu','South India',21,'Quintal/Ha',29800,'INR/Quintal',625800,494800,22);