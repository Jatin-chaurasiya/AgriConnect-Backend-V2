INSERT INTO tbl_disease
(disease_name, symptoms, prevention, medicine, dosage, spray_interval, crop_id)
VALUES

-- =====================================================
-- RICE (crop_id = 1)
-- =====================================================
('Blast','Brown diamond-shaped lesions on leaves','Use resistant varieties','Tricyclazole','0.6 g/L','10-15 Days',1),
('Bacterial Leaf Blight','Yellowing and drying of leaves','Avoid excess nitrogen','Streptocycline','0.5 g/L','10 Days',1),
('Sheath Blight','Oval lesions on leaf sheath','Maintain proper spacing','Validamycin','2 ml/L','10 Days',1),
('Stem Borer','Dead heart and white ear heads','Use pheromone traps','Chlorantraniliprole','0.4 ml/L','15 Days',1),
('Brown Planthopper','Leaves turn yellow and dry','Avoid excess irrigation','Imidacloprid','0.3 ml/L','10 Days',1),

-- =====================================================
-- MAIZE (crop_id = 2)
-- =====================================================
('Fall Armyworm','Holes in leaves','Field monitoring','Emamectin Benzoate','0.4 g/L','10 Days',2),
('Turcicum Leaf Blight','Long grey lesions','Disease resistant varieties','Mancozeb','2.5 g/L','10 Days',2),
('Downy Mildew','White fungal growth','Seed treatment','Metalaxyl','2 g/kg seed','15 Days',2),
('Stem Borer','Tunnel inside stem','Destroy infected plants','Chlorantraniliprole','0.4 ml/L','15 Days',2),
('Rust','Orange pustules on leaves','Crop rotation','Propiconazole','1 ml/L','12 Days',2),

-- =====================================================
-- CHICKPEA (crop_id = 3)
-- =====================================================
('Wilt','Sudden wilting','Seed treatment','Carbendazim','2 g/kg seed','Before Sowing',3),
('Ascochyta Blight','Dark spots on leaves','Crop rotation','Mancozeb','2.5 g/L','10 Days',3),
('Botrytis Gray Mold','Gray fungal growth','Avoid dense planting','Carbendazim','1 g/L','10 Days',3),
('Pod Borer','Holes in pods','Pheromone traps','Spinosad','0.5 ml/L','10 Days',3),
('Root Rot','Root decay','Proper drainage','Copper Oxychloride','2.5 g/L','15 Days',3),

-- =====================================================
-- KIDNEY BEANS (crop_id = 4)
-- =====================================================
('Anthracnose','Black lesions on pods','Use healthy seed','Carbendazim','1 g/L','10 Days',4),
('Rust','Orange pustules','Crop sanitation','Hexaconazole','1 ml/L','12 Days',4),
('Powdery Mildew','White powder on leaves','Avoid overcrowding','Wettable Sulphur','2 g/L','10 Days',4),
('Bean Aphid','Curling of leaves','Remove weeds','Imidacloprid','0.3 ml/L','10 Days',4),
('Root Rot','Root decay','Good drainage','Copper Oxychloride','2.5 g/L','15 Days',4),

-- =====================================================
-- PIGEON PEAS (crop_id = 5)
-- =====================================================
('Wilt','Plant wilting','Seed treatment','Carbendazim','2 g/kg seed','Before Sowing',5),
('Sterility Mosaic','No flowering','Use resistant varieties','Dimethoate','2 ml/L','15 Days',5),
('Pod Borer','Damaged pods','Pheromone traps','Spinosad','0.5 ml/L','10 Days',5),
('Leaf Spot','Brown spots','Crop rotation','Mancozeb','2.5 g/L','10 Days',5),
('Root Rot','Root decay','Good drainage','Copper Oxychloride','2.5 g/L','15 Days',5),

-- =====================================================
-- MOTH BEANS (crop_id = 6)
-- =====================================================
('Yellow Mosaic Virus','Yellow patches','Vector control','Imidacloprid','0.3 ml/L','10 Days',6),
('Powdery Mildew','White powder','Avoid overcrowding','Wettable Sulphur','2 g/L','10 Days',6),
('Leaf Spot','Brown spots','Crop sanitation','Mancozeb','2.5 g/L','10 Days',6),
('Pod Borer','Damaged pods','Pheromone traps','Spinosad','0.5 ml/L','10 Days',6),
('Root Rot','Root decay','Proper drainage','Copper Oxychloride','2.5 g/L','15 Days',6),

-- =====================================================
-- MUNG BEAN (crop_id = 7)
-- =====================================================
('Yellow Mosaic Virus','Yellow mosaic leaves','Vector control','Imidacloprid','0.3 ml/L','10 Days',7),
('Leaf Spot','Brown spots','Crop rotation','Mancozeb','2.5 g/L','10 Days',7),
('Powdery Mildew','White fungal growth','Avoid overcrowding','Wettable Sulphur','2 g/L','10 Days',7),
('Pod Borer','Damaged pods','Spinosad spray','Spinosad','0.5 ml/L','10 Days',7),
('Root Rot','Root decay','Good drainage','Copper Oxychloride','2.5 g/L','15 Days',7),

-- =====================================================
-- BLACK GRAM (crop_id = 8)
-- =====================================================
('Yellow Mosaic Virus','Yellow patches on leaves','Use resistant varieties','Imidacloprid','0.3 ml/L','10 Days',8),
('Leaf Spot','Brown lesions','Crop sanitation','Mancozeb','2.5 g/L','10 Days',8),
('Powdery Mildew','White powder on leaves','Avoid dense crop','Wettable Sulphur','2 g/L','10 Days',8),
('Pod Borer','Damaged pods','Pheromone traps','Spinosad','0.5 ml/L','10 Days',8),
('Root Rot','Root decay','Good drainage','Copper Oxychloride','2.5 g/L','15 Days',8),

-- =====================================================
-- LENTIL (crop_id = 9)
-- =====================================================
('Wilt','Sudden wilting of plants','Seed treatment','Carbendazim','2 g/kg seed','Before Sowing',9),
('Rust','Brown pustules on leaves','Crop rotation','Propiconazole','1 ml/L','10 Days',9),
('Powdery Mildew','White powder on leaves','Avoid dense planting','Wettable Sulphur','2 g/L','10 Days',9),
('Pod Borer','Damaged pods','Pheromone traps','Spinosad','0.5 ml/L','10 Days',9),
('Root Rot','Root decay','Proper drainage','Copper Oxychloride','2.5 g/L','15 Days',9),

-- =====================================================
-- POMEGRANATE (crop_id = 10)
-- =====================================================
('Bacterial Blight','Black spots on fruits','Prune infected branches','Copper Oxychloride','2.5 g/L','15 Days',10),
('Fruit Rot','Rotting fruits','Proper sanitation','Carbendazim','1 g/L','10 Days',10),
('Leaf Spot','Brown spots','Remove infected leaves','Mancozeb','2.5 g/L','10 Days',10),
('Aphid','Curling of leaves','Control weeds','Imidacloprid','0.3 ml/L','10 Days',10),
('Mealy Bug','White cotton-like insects','Regular monitoring','Thiamethoxam','0.25 g/L','15 Days',10),

-- =====================================================
-- BANANA (crop_id = 11)
-- =====================================================
('Panama Wilt','Yellowing and wilting','Use healthy suckers','Carbendazim','2 g/L','15 Days',11),
('Sigatoka Leaf Spot','Yellow streaks on leaves','Remove infected leaves','Propiconazole','1 ml/L','10 Days',11),
('Bunchy Top Virus','Stunted growth','Use disease-free plants','Imidacloprid','0.3 ml/L','15 Days',11),
('Rhizome Weevil','Damage to rhizome','Field sanitation','Chlorpyrifos','2 ml/L','20 Days',11),
('Nematodes','Poor root growth','Soil treatment','Carbofuran','10 g/plant','30 Days',11),

-- =====================================================
-- MANGO (crop_id = 12)
-- =====================================================
('Anthracnose','Black lesions on fruits','Pruning and sanitation','Carbendazim','1 g/L','10 Days',12),
('Powdery Mildew','White powder on flowers','Avoid excess humidity','Wettable Sulphur','2 g/L','10 Days',12),
('Fruit Fly','Maggots in fruits','Use fruit traps','Spinosad','0.5 ml/L','15 Days',12),
('Stem Borer','Holes in stem','Remove affected branches','Chlorpyrifos','2 ml/L','20 Days',12),
('Sooty Mold','Black fungal layer','Control insects','Copper Oxychloride','2.5 g/L','15 Days',12),

-- =====================================================
-- GRAPES (crop_id = 13)
-- =====================================================
('Downy Mildew','Yellow oil spots','Proper pruning','Metalaxyl','2 g/L','10 Days',13),
('Powdery Mildew','White powder on leaves','Good air circulation','Wettable Sulphur','2 g/L','10 Days',13),
('Anthracnose','Black lesions','Field sanitation','Carbendazim','1 g/L','10 Days',13),
('Thrips','Leaf curling','Regular monitoring','Fipronil','1 ml/L','15 Days',13),
('Mealy Bug','White insects on vines','Pruning','Thiamethoxam','0.25 g/L','15 Days',13),

-- =====================================================
-- WATERMELON (crop_id = 14)
-- =====================================================
('Downy Mildew','Yellow spots','Crop rotation','Metalaxyl','2 g/L','10 Days',14),
('Powdery Mildew','White powder','Avoid overcrowding','Wettable Sulphur','2 g/L','10 Days',14),
('Anthracnose','Dark fruit lesions','Use healthy seeds','Carbendazim','1 g/L','10 Days',14),
('Fruit Fly','Damaged fruits','Use traps','Spinosad','0.5 ml/L','15 Days',14),
('Aphid','Leaf curling','Weed management','Imidacloprid','0.3 ml/L','10 Days',14),

-- =====================================================
-- MUSKMELON (crop_id = 15)
-- =====================================================
('Downy Mildew','Yellow patches','Crop rotation','Metalaxyl','2 g/L','10 Days',15),
('Powdery Mildew','White powder','Avoid dense crop','Wettable Sulphur','2 g/L','10 Days',15),
('Anthracnose','Dark lesions','Use disease-free seed','Carbendazim','1 g/L','10 Days',15),
('Fruit Fly','Larvae inside fruits','Use traps','Spinosad','0.5 ml/L','15 Days',15),
('Aphid','Curling leaves','Field sanitation','Imidacloprid','0.3 ml/L','10 Days',15),

-- =====================================================
-- APPLE (crop_id = 16)
-- =====================================================
('Apple Scab','Olive-green spots on leaves and fruits','Prune infected branches','Mancozeb','2.5 g/L','10 Days',16),
('Powdery Mildew','White powder on leaves','Maintain proper air circulation','Wettable Sulphur','2 g/L','10 Days',16),
('Fire Blight','Blackening of shoots and flowers','Remove infected branches','Streptocycline','0.5 g/L','15 Days',16),
('Codling Moth','Holes in fruits','Use pheromone traps','Emamectin Benzoate','0.4 g/L','15 Days',16),
('Aphid','Leaf curling and yellowing','Control weeds','Imidacloprid','0.3 ml/L','10 Days',16),

-- =====================================================
-- ORANGE (crop_id = 17)
-- =====================================================
('Citrus Canker','Raised lesions on leaves and fruits','Use disease-free plants','Copper Oxychloride','2.5 g/L','15 Days',17),
('Gummosis','Oozing gum from trunk','Avoid waterlogging','Metalaxyl','2 g/L','20 Days',17),
('Greening Disease','Yellow shoots and small fruits','Remove infected plants','Imidacloprid','0.3 ml/L','15 Days',17),
('Leaf Miner','Zig-zag mines on leaves','Regular monitoring','Thiamethoxam','0.25 g/L','15 Days',17),
('Black Fly','Sooty mold on leaves','Maintain orchard hygiene','Imidacloprid','0.3 ml/L','10 Days',17),

-- =====================================================
-- PAPAYA (crop_id = 18)
-- =====================================================
('Papaya Ring Spot Virus','Ring spots on fruits','Use healthy seedlings','Imidacloprid','0.3 ml/L','10 Days',18),
('Powdery Mildew','White powder on leaves','Avoid overcrowding','Wettable Sulphur','2 g/L','10 Days',18),
('Anthracnose','Black lesions on fruits','Remove infected fruits','Carbendazim','1 g/L','10 Days',18),
('Foot Rot','Stem base rotting','Proper drainage','Copper Oxychloride','2.5 g/L','15 Days',18),
('Mealy Bug','White cotton-like insects','Field sanitation','Thiamethoxam','0.25 g/L','15 Days',18),

-- =====================================================
-- COCONUT (crop_id = 19)
-- =====================================================
('Bud Rot','Rotting of central bud','Good drainage','Copper Oxychloride','2.5 g/L','20 Days',19),
('Stem Bleeding','Brown liquid oozing from trunk','Avoid injuries','Bordeaux Paste','Apply on trunk','30 Days',19),
('Root Wilt','Yellowing leaves','Balanced nutrition','Potassium Nitrate','2 g/L','30 Days',19),
('Rhinoceros Beetle','Damaged crown','Use pheromone traps','Carbaryl','4 g/L','20 Days',19),
('Red Palm Weevil','Holes in trunk','Regular monitoring','Chlorpyrifos','2 ml/L','20 Days',19),

-- =====================================================
-- COTTON (crop_id = 20)
-- =====================================================
('Bacterial Blight','Angular leaf spots','Use resistant varieties','Copper Oxychloride','2.5 g/L','10 Days',20),
('Alternaria Leaf Spot','Brown concentric spots','Crop rotation','Mancozeb','2.5 g/L','10 Days',20),
('Pink Bollworm','Damaged cotton bolls','Use pheromone traps','Emamectin Benzoate','0.4 g/L','15 Days',20),
('Whitefly','Yellowing leaves','Remove weeds','Imidacloprid','0.3 ml/L','10 Days',20),
('Aphid','Curling leaves','Field sanitation','Thiamethoxam','0.25 g/L','10 Days',20),

-- =====================================================
-- JUTE (crop_id = 21)
-- =====================================================
('Stem Rot','Rotting stem','Good drainage','Copper Oxychloride','2.5 g/L','15 Days',21),
('Anthracnose','Brown lesions','Use healthy seed','Carbendazim','1 g/L','10 Days',21),
('Leaf Mosaic','Yellow mosaic','Vector control','Imidacloprid','0.3 ml/L','10 Days',21),
('Hairy Caterpillar','Leaves eaten','Field monitoring','Spinosad','0.5 ml/L','10 Days',21),
('Semilooper','Defoliation','Pheromone traps','Emamectin Benzoate','0.4 g/L','15 Days',21),

-- =====================================================
-- COFFEE (crop_id = 22)
-- =====================================================
('Coffee Leaf Rust','Orange powder on leaves','Shade management','Hexaconazole','1 ml/L','15 Days',22),
('Berry Disease','Black berries','Pruning','Copper Oxychloride','2.5 g/L','15 Days',22),
('Black Rot','Rotting berries','Good sanitation','Carbendazim','1 g/L','10 Days',22),
('White Stem Borer','Stem holes','Remove affected stems','Chlorpyrifos','2 ml/L','20 Days',22),
('Mealy Bug','White insects','Regular monitoring','Thiamethoxam','0.25 g/L','15 Days',22);