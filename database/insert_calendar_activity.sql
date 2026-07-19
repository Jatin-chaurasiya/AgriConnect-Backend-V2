INSERT INTO tbl_calendar_activity
(day_number, activity, description, crop_id)
VALUES

-- =====================================================
-- RICE (crop_id = 1)
-- =====================================================
(0,'Land Preparation','Prepare field and puddling before transplanting.',1),
(1,'Sowing/Transplanting','Transplant healthy seedlings.',1),
(30,'Fertilizer Application','Apply top dressing of nitrogen fertilizer.',1),
(70,'Pest & Disease Management','Monitor field and spray if required.',1),
(120,'Harvesting','Harvest mature crop and dry grains.',1),

-- =====================================================
-- MAIZE (crop_id = 2)
-- =====================================================
(0,'Land Preparation','Prepare field with proper tillage.',2),
(1,'Sowing','Sow certified maize seeds.',2),
(25,'Fertilizer Application','Apply nitrogen fertilizer.',2),
(55,'Weed & Pest Control','Remove weeds and inspect pests.',2),
(110,'Harvesting','Harvest fully matured cobs.',2),

-- =====================================================
-- CHICKPEA (crop_id = 3)
-- =====================================================
(0,'Land Preparation','Prepare well-drained soil.',3),
(1,'Sowing','Sow treated chickpea seeds.',3),
(30,'Fertilizer Application','Apply recommended fertilizer.',3),
(60,'Disease Monitoring','Inspect for wilt and pod borer.',3),
(110,'Harvesting','Harvest when pods turn brown.',3),

-- =====================================================
-- KIDNEY BEANS (crop_id = 4)
-- =====================================================
(0,'Land Preparation','Prepare fertile soil.',4),
(1,'Sowing','Sow treated bean seeds.',4),
(25,'Fertilizer Application','Apply basal fertilizer.',4),
(55,'Disease Management','Inspect for fungal diseases.',4),
(95,'Harvesting','Harvest mature pods.',4),

-- =====================================================
-- PIGEON PEAS (crop_id = 5)
-- =====================================================
(0,'Land Preparation','Prepare field before sowing.',5),
(1,'Sowing','Sow certified pigeon pea seeds.',5),
(35,'Fertilizer Application','Apply recommended fertilizer.',5),
(90,'Pest Monitoring','Monitor pod borer infestation.',5),
(170,'Harvesting','Harvest dry pods.',5),

-- =====================================================
-- MOTH BEANS (crop_id = 6)
-- =====================================================
(0,'Land Preparation','Prepare sandy soil.',6),
(1,'Sowing','Sow quality seeds.',6),
(25,'Fertilizer Application','Apply balanced fertilizer.',6),
(45,'Disease Monitoring','Check for leaf spot and mosaic.',6),
(80,'Harvesting','Harvest mature pods.',6),

-- =====================================================
-- MUNG BEAN (crop_id = 7)
-- =====================================================
(0,'Land Preparation','Prepare fine seed bed.',7),
(1,'Sowing','Sow treated mung bean seeds.',7),
(20,'Fertilizer Application','Apply basal fertilizer.',7),
(45,'Pest Management','Monitor pod borer and aphids.',7),
(70,'Harvesting','Harvest mature pods.',7),

-- =====================================================
-- BLACK GRAM (crop_id = 8)
-- =====================================================
(0,'Land Preparation','Prepare field properly.',8),
(1,'Sowing','Sow certified black gram seeds.',8),
(20,'Fertilizer Application','Apply recommended fertilizer.',8),
(45,'Disease Monitoring','Inspect for yellow mosaic virus.',8),
(75,'Harvesting','Harvest fully matured crop.',8),

-- =====================================================
-- LENTIL (crop_id = 9)
-- =====================================================
(0,'Land Preparation','Prepare well-drained fertile soil.',9),
(1,'Sowing','Sow treated lentil seeds.',9),
(25,'Fertilizer Application','Apply recommended basal fertilizer.',9),
(60,'Disease Monitoring','Inspect crop for rust and wilt.',9),
(110,'Harvesting','Harvest when pods become brown.',9),

-- =====================================================
-- POMEGRANATE (crop_id = 10)
-- =====================================================
(0,'Planting','Plant healthy grafted saplings.',10),
(30,'Fertilizer Application','Apply organic manure and NPK fertilizer.',10),
(120,'Pruning & Pest Management','Prune branches and monitor pests.',10),
(180,'Fruit Development','Maintain irrigation and nutrient supply.',10),
(270,'Harvesting','Harvest mature fruits carefully.',10),

-- =====================================================
-- BANANA (crop_id = 11)
-- =====================================================
(0,'Planting','Plant healthy banana suckers.',11),
(30,'Fertilizer Application','Apply recommended fertilizer dose.',11),
(120,'Earthing Up','Support plants and remove weeds.',11),
(210,'Bunch Development','Cover bunches and monitor diseases.',11),
(330,'Harvesting','Harvest mature banana bunches.',11),

-- =====================================================
-- MANGO (crop_id = 12)
-- =====================================================
(0,'Planting','Plant healthy grafted mango saplings.',12),
(60,'Fertilizer Application','Apply manure and NPK fertilizer.',12),
(120,'Flowering Management','Monitor flowering and pest attacks.',12),
(180,'Fruit Development','Provide irrigation and fruit protection.',12),
(300,'Harvesting','Harvest ripe mango fruits.',12),

-- =====================================================
-- GRAPES (crop_id = 13)
-- =====================================================
(0,'Pruning','Prune vines before new season.',13),
(30,'Fertilizer Application','Apply recommended fertilizers.',13),
(60,'Training','Train vines on support system.',13),
(90,'Disease Monitoring','Inspect for mildew and insect attack.',13),
(130,'Harvesting','Harvest mature grape bunches.',13),

-- =====================================================
-- WATERMELON (crop_id = 14)
-- =====================================================
(0,'Land Preparation','Prepare raised beds.',14),
(1,'Sowing','Sow treated watermelon seeds.',14),
(25,'Fertilizer Application','Apply balanced fertilizer.',14),
(50,'Fruit Development','Monitor irrigation and pest attack.',14),
(80,'Harvesting','Harvest ripe watermelons.',14),

-- =====================================================
-- MUSKMELON (crop_id = 15)
-- =====================================================
(0,'Land Preparation','Prepare well-drained sandy soil.',15),
(1,'Sowing','Sow quality muskmelon seeds.',15),
(20,'Fertilizer Application','Apply basal fertilizer.',15),
(45,'Disease Monitoring','Inspect crop for mildew and fruit fly.',15),
(75,'Harvesting','Harvest mature fruits carefully.',15),

-- =====================================================
-- APPLE (crop_id = 16)
-- =====================================================
(0,'Planting','Plant healthy grafted apple saplings.',16),
(45,'Fertilizer Application','Apply organic manure and recommended fertilizers.',16),
(90,'Pruning & Disease Monitoring','Prune branches and monitor apple scab.',16),
(180,'Fruit Development','Maintain irrigation and nutrient supply.',16),
(300,'Harvesting','Harvest mature apples carefully.',16),

-- =====================================================
-- ORANGE (crop_id = 17)
-- =====================================================
(0,'Planting','Plant healthy orange saplings.',17),
(40,'Fertilizer Application','Apply FYM and NPK fertilizers.',17),
(100,'Pest & Disease Monitoring','Inspect for citrus canker and pests.',17),
(180,'Fruit Development','Maintain irrigation and nutrient supply.',17),
(300,'Harvesting','Harvest mature oranges.',17),

-- =====================================================
-- PAPAYA (crop_id = 18)
-- =====================================================
(0,'Planting','Plant healthy papaya seedlings.',18),
(30,'Fertilizer Application','Apply recommended fertilizers.',18),
(90,'Disease Monitoring','Monitor for ring spot virus and mildew.',18),
(180,'Fruit Development','Maintain regular irrigation.',18),
(270,'Harvesting','Harvest ripe papaya fruits.',18),

-- =====================================================
-- COCONUT (crop_id = 19)
-- =====================================================
(0,'Planting','Plant healthy coconut seedlings.',19),
(60,'Fertilizer Application','Apply organic manure and fertilizers.',19),
(150,'Pest & Disease Monitoring','Monitor rhinoceros beetle and bud rot.',19),
(240,'Nut Development','Maintain irrigation during dry season.',19),
(330,'Harvesting','Harvest mature coconuts.',19),

-- =====================================================
-- COTTON (crop_id = 20)
-- =====================================================
(0,'Land Preparation','Prepare field before sowing.',20),
(1,'Sowing','Sow certified cotton seeds.',20),
(35,'Fertilizer Application','Apply nitrogen and potash fertilizers.',20),
(80,'Pest Monitoring','Monitor pink bollworm and whitefly.',20),
(160,'Harvesting','Harvest fully opened cotton bolls.',20),

-- =====================================================
-- JUTE (crop_id = 21)
-- =====================================================
(0,'Land Preparation','Prepare fertile soil before sowing.',21),
(1,'Sowing','Sow certified jute seeds.',21),
(30,'Fertilizer Application','Apply recommended fertilizer dose.',21),
(70,'Weed & Disease Management','Remove weeds and monitor diseases.',21),
(120,'Harvesting','Harvest mature jute plants for retting.',21),

-- =====================================================
-- COFFEE (crop_id = 22)
-- =====================================================
(0,'Planting','Plant healthy coffee seedlings.',22),
(45,'Fertilizer Application','Apply organic manure and NPK fertilizers.',22),
(120,'Pruning & Disease Monitoring','Prune plants and inspect coffee leaf rust.',22),
(210,'Berry Development','Maintain irrigation and shade management.',22),
(330,'Harvesting','Harvest ripe coffee cherries.',22);