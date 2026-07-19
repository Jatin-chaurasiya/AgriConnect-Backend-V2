INSERT INTO tbl_fertilizer
(stage, day_number, fertilizer_name, quantity, unit, purpose, crop_id)
VALUES

-- =====================================================
-- RICE (crop_id = 1)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',2000,'kg/acre','Improve soil fertility',1),
('Basal',0,'DAP',50,'kg/acre','Root establishment',1),
('Tillering',25,'Urea',45,'kg/acre','Vegetative growth',1),
('Panicle Initiation',50,'Urea',25,'kg/acre','Panicle development',1),
('Micronutrient',55,'Zinc Sulphate',10,'kg/acre','Prevent zinc deficiency',1),

-- =====================================================
-- MAIZE (crop_id = 2)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1500,'kg/acre','Improve soil fertility',2),
('Basal',0,'DAP',40,'kg/acre','Root development',2),
('Vegetative',25,'Urea',40,'kg/acre','Leaf growth',2),
('Knee High Stage',40,'Urea',30,'kg/acre','Rapid plant growth',2),
('Flowering',55,'MOP',20,'kg/acre','Cob development',2),

-- =====================================================
-- CHICKPEA (crop_id = 3)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1000,'kg/acre','Improve soil fertility',3),
('Basal',0,'DAP',35,'kg/acre','Root development',3),
('Vegetative',30,'Urea',15,'kg/acre','Vegetative growth',3),
('Flowering',45,'NPK 19:19:19',10,'kg/acre','Flower development',3),
('Pod Formation',60,'Potash',10,'kg/acre','Pod filling',3),

-- =====================================================
-- KIDNEY BEANS (crop_id = 4)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1200,'kg/acre','Improve soil fertility',4),
('Basal',0,'DAP',35,'kg/acre','Root development',4),
('Vegetative',20,'Urea',20,'kg/acre','Leaf growth',4),
('Flowering',40,'NPK 19:19:19',12,'kg/acre','Flower initiation',4),
('Pod Formation',60,'Potash',12,'kg/acre','Pod development',4),

-- =====================================================
-- PIGEON PEAS (crop_id = 5)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1500,'kg/acre','Improve soil fertility',5),
('Basal',0,'DAP',40,'kg/acre','Root establishment',5),
('Vegetative',35,'Urea',20,'kg/acre','Leaf growth',5),
('Flowering',80,'NPK 19:19:19',15,'kg/acre','Flower development',5),
('Pod Formation',120,'Potash',15,'kg/acre','Pod filling',5),

-- =====================================================
-- MOTH BEANS (crop_id = 6)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1000,'kg/acre','Improve soil fertility',6),
('Basal',0,'DAP',25,'kg/acre','Root development',6),
('Vegetative',20,'Urea',15,'kg/acre','Leaf growth',6),
('Flowering',35,'NPK 19:19:19',8,'kg/acre','Flower development',6),
('Pod Formation',55,'Potash',8,'kg/acre','Pod filling',6),

-- =====================================================
-- MUNG BEAN (crop_id = 7)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1000,'kg/acre','Improve soil fertility',7),
('Basal',0,'DAP',25,'kg/acre','Root development',7),
('Vegetative',18,'Urea',15,'kg/acre','Leaf growth',7),
('Flowering',30,'NPK 19:19:19',8,'kg/acre','Flower development',7),
('Pod Formation',45,'Potash',8,'kg/acre','Pod filling',7),

-- =====================================================
-- BLACK GRAM (crop_id = 8)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1000,'kg/acre','Improve soil fertility',8),
('Basal',0,'DAP',25,'kg/acre','Root development',8),
('Vegetative',20,'Urea',15,'kg/acre','Leaf growth',8),
('Flowering',35,'NPK 19:19:19',10,'kg/acre','Flower development',8),
('Pod Formation',50,'Potash',10,'kg/acre','Pod filling',8),

-- =====================================================
-- LENTIL (crop_id = 9)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1000,'kg/acre','Improve soil fertility',9),
('Basal',0,'DAP',30,'kg/acre','Root development',9),
('Vegetative',25,'Urea',15,'kg/acre','Leaf growth',9),
('Flowering',40,'NPK 19:19:19',10,'kg/acre','Flower development',9),
('Pod Formation',60,'Potash',10,'kg/acre','Pod filling',9),

-- =====================================================
-- POMEGRANATE (crop_id = 10)
-- =====================================================
('Pre-Season',-15,'Farm Yard Manure',20,'kg/tree','Improve soil fertility',10),
('Vegetative',30,'Urea',1.5,'kg/tree','Vegetative growth',10),
('Flowering',90,'NPK 19:19:19',2,'kg/tree','Flower development',10),
('Fruit Development',150,'MOP',1.5,'kg/tree','Fruit quality',10),
('Micronutrient',180,'Zinc Sulphate',250,'g/tree','Micronutrient supply',10),

-- =====================================================
-- BANANA (crop_id = 11)
-- =====================================================
('Planting',0,'Farm Yard Manure',5000,'kg/acre','Soil fertility',11),
('Basal',0,'DAP',50,'kg/acre','Root establishment',11),
('Vegetative',45,'Urea',50,'kg/acre','Leaf growth',11),
('Bunch Formation',120,'MOP',40,'kg/acre','Fruit development',11),
('Micronutrient',150,'Magnesium Sulphate',15,'kg/acre','Fruit quality',11),

-- =====================================================
-- MANGO (crop_id = 12)
-- =====================================================
('Pre-Monsoon',-20,'Farm Yard Manure',25,'kg/tree','Improve soil fertility',12),
('Vegetative',30,'Urea',2,'kg/tree','Leaf growth',12),
('Flowering',90,'NPK 19:19:19',2,'kg/tree','Flower initiation',12),
('Fruit Development',150,'MOP',2,'kg/tree','Fruit quality',12),
('Micronutrient',180,'Boron',100,'g/tree','Fruit setting',12),

-- =====================================================
-- GRAPES (crop_id = 13)
-- =====================================================
('Pruning',0,'Farm Yard Manure',15,'kg/vine','Soil fertility',13),
('Vegetative',20,'Urea',25,'kg/acre','Shoot growth',13),
('Flowering',45,'DAP',20,'kg/acre','Flower initiation',13),
('Berry Development',75,'MOP',25,'kg/acre','Berry quality',13),
('Micronutrient',90,'Calcium Nitrate',20,'kg/acre','Berry firmness',13),

-- =====================================================
-- WATERMELON (crop_id = 14)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',2000,'kg/acre','Improve soil fertility',14),
('Basal',0,'DAP',35,'kg/acre','Root establishment',14),
('Vegetative',20,'Urea',25,'kg/acre','Leaf growth',14),
('Flowering',35,'NPK 19:19:19',15,'kg/acre','Flower development',14),
('Fruit Development',50,'MOP',20,'kg/acre','Fruit size',14),

-- =====================================================
-- MUSKMELON (crop_id = 15)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',2000,'kg/acre','Improve soil fertility',15),
('Basal',0,'DAP',35,'kg/acre','Root establishment',15),
('Vegetative',20,'Urea',20,'kg/acre','Leaf growth',15),
('Flowering',35,'NPK 19:19:19',15,'kg/acre','Flower development',15),
('Fruit Development',50,'MOP',20,'kg/acre','Fruit quality',15),

-- =====================================================
-- APPLE (crop_id = 16)
-- =====================================================
('Pre-Season',-20,'Farm Yard Manure',25,'kg/tree','Improve soil fertility',16),
('Vegetative',30,'Urea',1.5,'kg/tree','Leaf growth',16),
('Flowering',80,'NPK 19:19:19',2,'kg/tree','Flower development',16),
('Fruit Development',140,'MOP',2,'kg/tree','Fruit quality',16),
('Micronutrient',170,'Calcium Nitrate',500,'g/tree','Improve fruit firmness',16),

-- =====================================================
-- ORANGE (crop_id = 17)
-- =====================================================
('Pre-Season',-20,'Farm Yard Manure',20,'kg/tree','Improve soil fertility',17),
('Vegetative',30,'Urea',1.5,'kg/tree','Vegetative growth',17),
('Flowering',90,'NPK 19:19:19',2,'kg/tree','Flower initiation',17),
('Fruit Development',150,'MOP',2,'kg/tree','Fruit quality',17),
('Micronutrient',180,'Zinc Sulphate',250,'g/tree','Prevent zinc deficiency',17),

-- =====================================================
-- PAPAYA (crop_id = 18)
-- =====================================================
('Land Preparation',-10,'Farm Yard Manure',3000,'kg/acre','Improve soil fertility',18),
('Planting',0,'DAP',40,'kg/acre','Root establishment',18),
('Vegetative',45,'Urea',30,'kg/acre','Leaf growth',18),
('Flowering',90,'NPK 19:19:19',20,'kg/acre','Flower development',18),
('Fruit Development',150,'MOP',25,'kg/acre','Fruit quality',18),

-- =====================================================
-- COCONUT (crop_id = 19)
-- =====================================================
('Pre-Monsoon',-15,'Farm Yard Manure',25,'kg/tree','Improve soil fertility',19),
('Vegetative',60,'Urea',2,'kg/tree','Leaf growth',19),
('Nut Formation',150,'NPK 19:19:19',2,'kg/tree','Nut development',19),
('Nut Development',240,'MOP',2,'kg/tree','Improve nut size',19),
('Micronutrient',270,'Magnesium Sulphate',500,'g/tree','Prevent magnesium deficiency',19),

-- =====================================================
-- COTTON (crop_id = 20)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',2000,'kg/acre','Improve soil fertility',20),
('Basal',0,'DAP',50,'kg/acre','Root establishment',20),
('Square Formation',45,'Urea',35,'kg/acre','Vegetative growth',20),
('Flowering',70,'NPK 19:19:19',20,'kg/acre','Boll development',20),
('Boll Development',100,'MOP',20,'kg/acre','Improve boll quality',20),

-- =====================================================
-- JUTE (crop_id = 21)
-- =====================================================
('Land Preparation',-7,'Farm Yard Manure',1500,'kg/acre','Improve soil fertility',21),
('Basal',0,'DAP',35,'kg/acre','Root establishment',21),
('Vegetative',30,'Urea',30,'kg/acre','Stem growth',21),
('Rapid Growth',50,'Urea',20,'kg/acre','Fiber development',21),
('Micronutrient',60,'Zinc Sulphate',10,'kg/acre','Improve fiber quality',21),

-- =====================================================
-- COFFEE (crop_id = 22)
-- =====================================================
('Pre-Monsoon',-20,'Farm Yard Manure',20,'kg/tree','Improve soil fertility',22),
('Vegetative',45,'Urea',1,'kg/tree','Leaf growth',22),
('Flowering',90,'NPK 19:19:19',1.5,'kg/tree','Flower development',22),
('Berry Development',150,'MOP',1.5,'kg/tree','Berry filling',22),
('Post Harvest',220,'Rock Phosphate',1,'kg/tree','Restore soil nutrients',22);