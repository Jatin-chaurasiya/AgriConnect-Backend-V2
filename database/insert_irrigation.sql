INSERT INTO tbl_irrigation
(day_number, stage, description, crop_id)
VALUES

-- =====================================================
-- RICE (crop_id = 1)
-- =====================================================
('0','Land Preparation','Flood the field before transplanting.',1),
('15','Tillering','Maintain 2-5 cm standing water.',1),
('35','Vegetative','Maintain adequate water level.',1),
('60','Flowering','Ensure continuous irrigation.',1),
('105','Before Harvest','Stop irrigation 7-10 days before harvest.',1),

-- =====================================================
-- MAIZE (crop_id = 2)
-- =====================================================
('0','Sowing','Provide light irrigation after sowing.',2),
('20','Vegetative','Irrigate during vegetative stage.',2),
('40','Knee High','Maintain proper soil moisture.',2),
('60','Flowering','Critical irrigation at tasseling and silking.',2),
('90','Grain Filling','Final irrigation before maturity.',2),

-- =====================================================
-- CHICKPEA (crop_id = 3)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',3),
('30','Vegetative','Irrigate only if soil is dry.',3),
('50','Flowering','Critical irrigation at flowering.',3),
('70','Pod Formation','Maintain optimum moisture.',3),
('90','Maturity','Stop irrigation before harvesting.',3),

-- =====================================================
-- KIDNEY BEANS (crop_id = 4)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',4),
('20','Vegetative','Maintain moderate soil moisture.',4),
('40','Flowering','Critical irrigation.',4),
('60','Pod Formation','Maintain moisture for pod filling.',4),
('80','Maturity','Stop irrigation before harvest.',4),

-- =====================================================
-- PIGEON PEAS (crop_id = 5)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',5),
('35','Vegetative','Irrigate during dry conditions.',5),
('80','Flowering','Critical irrigation.',5),
('120','Pod Formation','Maintain soil moisture.',5),
('160','Maturity','Stop irrigation before harvest.',5),

-- =====================================================
-- MOTH BEANS (crop_id = 6)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',6),
('20','Vegetative','Irrigate only if necessary.',6),
('35','Flowering','Critical irrigation.',6),
('55','Pod Formation','Maintain adequate moisture.',6),
('75','Harvest','Stop irrigation.',6),

-- =====================================================
-- MUNG BEAN (crop_id = 7)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',7),
('18','Vegetative','Maintain optimum moisture.',7),
('30','Flowering','Critical irrigation.',7),
('45','Pod Formation','Maintain soil moisture.',7),
('60','Harvest','Stop irrigation.',7),

-- =====================================================
-- BLACK GRAM (crop_id = 8)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',8),
('20','Vegetative','Maintain adequate moisture.',8),
('35','Flowering','Critical irrigation.',8),
('50','Pod Formation','Maintain moisture.',8),
('70','Harvest','Stop irrigation before harvesting.',8),

-- =====================================================
-- LENTIL (crop_id = 9)
-- =====================================================
('0','Sowing','Provide light irrigation after sowing.',9),
('25','Vegetative','Irrigate only if soil moisture is low.',9),
('45','Flowering','Critical irrigation during flowering.',9),
('65','Pod Formation','Maintain optimum soil moisture.',9),
('90','Harvest','Stop irrigation before harvesting.',9),

-- =====================================================
-- POMEGRANATE (crop_id = 10)
-- =====================================================
('0','Planting','Irrigate immediately after planting.',10),
('30','Vegetative','Irrigate every 7-10 days.',10),
('90','Flowering','Maintain adequate moisture.',10),
('150','Fruit Development','Regular irrigation for fruit growth.',10),
('250','Pre Harvest','Reduce irrigation before harvesting.',10),

-- =====================================================
-- BANANA (crop_id = 11)
-- =====================================================
('0','Planting','Irrigate immediately after planting.',11),
('30','Vegetative','Weekly irrigation recommended.',11),
('120','Bunch Formation','Maintain high soil moisture.',11),
('210','Fruit Development','Regular irrigation every 5-7 days.',11),
('330','Pre Harvest','Reduce irrigation before harvesting.',11),

-- =====================================================
-- MANGO (crop_id = 12)
-- =====================================================
('0','Planting','Provide irrigation after planting.',12),
('60','Vegetative','Irrigate every 10-15 days.',12),
('120','Flowering','Avoid water stress.',12),
('180','Fruit Development','Regular irrigation improves fruit quality.',12),
('300','Pre Harvest','Reduce irrigation before harvesting.',12),

-- =====================================================
-- GRAPES (crop_id = 13)
-- =====================================================
('0','Pruning','Provide irrigation after pruning.',13),
('30','Vegetative','Maintain optimum soil moisture.',13),
('60','Flowering','Critical irrigation.',13),
('90','Berry Development','Regular irrigation improves berry size.',13),
('130','Harvest','Stop irrigation before harvesting.',13),

-- =====================================================
-- WATERMELON (crop_id = 14)
-- =====================================================
('0','Sowing','Light irrigation after sowing.',14),
('20','Vegetative','Maintain soil moisture.',14),
('35','Flowering','Critical irrigation.',14),
('55','Fruit Development','Regular irrigation.',14),
('75','Harvest','Stop irrigation before harvesting.',14),

-- =====================================================
-- MUSKMELON (crop_id = 15)
-- =====================================================
('0','Sowing','Provide light irrigation.',15),
('20','Vegetative','Maintain optimum soil moisture.',15),
('35','Flowering','Critical irrigation.',15),
('50','Fruit Development','Regular irrigation.',15),
('70','Harvest','Stop irrigation before harvesting.',15),

-- =====================================================
-- APPLE (crop_id = 16)
-- =====================================================
('0','Planting','Provide irrigation immediately after planting.',16),
('45','Vegetative','Irrigate every 10-15 days depending on soil moisture.',16),
('90','Flowering','Critical irrigation during flowering stage.',16),
('150','Fruit Development','Maintain adequate moisture for fruit growth.',16),
('300','Pre Harvest','Reduce irrigation before harvesting.',16),

-- =====================================================
-- ORANGE (crop_id = 17)
-- =====================================================
('0','Planting','Provide irrigation after planting.',17),
('40','Vegetative','Irrigate every 7-10 days.',17),
('100','Flowering','Critical irrigation during flowering.',17),
('170','Fruit Development','Maintain optimum soil moisture.',17),
('300','Pre Harvest','Reduce irrigation before harvesting.',17),

-- =====================================================
-- PAPAYA (crop_id = 18)
-- =====================================================
('0','Planting','Provide irrigation immediately after planting.',18),
('30','Vegetative','Weekly irrigation recommended.',18),
('90','Flowering','Maintain optimum moisture.',18),
('180','Fruit Development','Regular irrigation every 5-7 days.',18),
('270','Harvest','Reduce irrigation before harvesting.',18),

-- =====================================================
-- COCONUT (crop_id = 19)
-- =====================================================
('0','Planting','Provide irrigation after planting.',19),
('60','Vegetative','Irrigate every 10-15 days.',19),
('150','Nut Formation','Critical irrigation for nut development.',19),
('240','Nut Development','Maintain adequate moisture.',19),
('330','Harvest','Reduce irrigation before harvesting.',19),

-- =====================================================
-- COTTON (crop_id = 20)
-- =====================================================
('0','Sowing','Provide light irrigation after sowing.',20),
('25','Vegetative','Maintain optimum soil moisture.',20),
('50','Square Formation','Critical irrigation.',20),
('80','Flowering','Regular irrigation during boll formation.',20),
('140','Harvest','Stop irrigation before harvesting.',20),

-- =====================================================
-- JUTE (crop_id = 21)
-- =====================================================
('0','Sowing','Provide irrigation after sowing.',21),
('20','Vegetative','Maintain adequate soil moisture.',21),
('45','Rapid Growth','Critical irrigation.',21),
('70','Stem Development','Regular irrigation.',21),
('110','Harvest','Stop irrigation before harvesting.',21),

-- =====================================================
-- COFFEE (crop_id = 22)
-- =====================================================
('0','Planting','Provide irrigation after planting.',22),
('45','Vegetative','Irrigate every 10-15 days.',22),
('90','Flowering','Critical irrigation for flowering.',22),
('180','Berry Development','Maintain adequate soil moisture.',22),
('300','Post Harvest','Light irrigation after harvest.',22);