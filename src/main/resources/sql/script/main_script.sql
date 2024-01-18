-- Country SCRIPT
INSERT INTO "UserInformation"."Country" ("Name", "Lon", "Lat")
VALUES
    ('FRANCE', 2.3522, 48.8566),
    ('PAKISTAN', 73.0479, 33.6844),
    ('BANGLADESH', 90.4125, 23.8103),
    ('CHINE', 116.4074, 39.9042),
    ('BRESIL', -47.9292, -15.7801),
    ('ETATS-UNIS', -77.0369, 38.8951),
    ('AUSTRALIE', 133.7751, -25.2744),
    ('TURQUIE', 35.2433, 38.9637),
    ('INDONESIE', 113.9213, -0.7893),
    ('BIRMANIE', 95.9550, 21.9162)
ON CONFLICT ("Name") DO NOTHING;

-- City SCRIPT
INSERT INTO "UserInformation"."City" ("Name", "CountryId")
VALUES
    (
        'CAEN',
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Name" = 'FRANCE')
    ),
    (
        'PARIS',
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Name" = 'FRANCE')
    )
ON CONFLICT ("Name") DO NOTHING;

-- TIGInfrastructure SCRIPT
INSERT INTO "UserInformation"."TIGInfrastructure" ("Name", "CityId")
VALUES
    (
        ('TIG_CAEN'),
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN')
    ),
    (
        ('TIG_PARIS'),
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'PARIS')
    )
ON CONFLICT ("Name") DO NOTHING;

-- Role SCRIPT
INSERT INTO "UserInformation"."Role" ("Name")
VALUES ('ROLE_USER'), ('ROLE_CITY'), ('ROLE_COUNTRY')
ON CONFLICT ("Name") DO NOTHING;

-- Authority SCRIPT
INSERT INTO "UserInformation"."Authority" ("Username", "RoleId", "Password")
VALUES
    (
        'TAN',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
    ),
    (
        'VAL',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
    ),
    (
        'ANGELINA',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
    ),
    (
        'CHRISTELLE',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
    ),
    (
        'RANDOM',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
    ),
    (
        'MAYOR-CAEN',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_CITY'),
        'TMP'
    ),
    (
        'PRESIDENT-FRANCE',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_COUNTRY'),
        'TMP'
    )
ON CONFLICT ("Username") DO NOTHING;

-- Family SCRIPT
INSERT INTO "UserInformation"."Family" ("Address")
VALUES
    (
        '3 Esp. Stéphane Hessel, 14000 Caen'
    ),
    (
        '6 Bd Maréchal Juin, 14000 Caen'
    )
ON CONFLICT ("Address") DO NOTHING;

-- User SCRIPT
INSERT INTO "UserInformation"."User" ("Name", "Lastname", "CityId", "Birthdate", "QuotaId", "ProfilePicture", "Gender", "AuthorityId", "FamilyId")
VALUES
    (
        'Tangui',
        'STEIMETZ',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2001-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'M',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'TAN'),
        (SELECT "id" FROM "UserInformation"."Family" WHERE "Address" = '3 Esp. Stéphane Hessel, 14000 Caen')
    ),
    (
        'Valentin',
        'LEBARBANCHON',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2000-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'M',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'VAL'),
        (SELECT "id" FROM "UserInformation"."Family" WHERE "Address" = '3 Esp. Stéphane Hessel, 14000 Caen')
    ),
    (
        'Angelina',
        'GOUDO',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('1999-01-29 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'F',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'ANGELINA'),
        (SELECT "id" FROM "UserInformation"."Family" WHERE "Address" = '3 Esp. Stéphane Hessel, 14000 Caen')
    ),
    (
        'Christelle',
        'BRONLESS',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('1995-04-23 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'F',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'CHRISTELLE'),
        (SELECT "id" FROM "UserInformation"."Family" WHERE "Address" = '3 Esp. Stéphane Hessel, 14000 Caen')
    ),
    (
        'Christelle',
        'RANDOM',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('1989-06-27 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'F',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'RANDOM'),
        (SELECT "id" FROM "UserInformation"."Family" WHERE "Address" = '6 Bd Maréchal Juin, 14000 Caen')
    ),
    (
        'Maire',
        'CAEN',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2017-05-15 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'M',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'MAYOR-CAEN'),
        null
    ),
    (
        'President',
        'FRANCE',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'PARIS'),
        TO_TIMESTAMP('1968-10-09 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'M',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'PRESIDENT-FRANCE'),
        null
    )
ON CONFLICT ("AuthorityId") DO NOTHING;

-- User Retribution SCRIPT
INSERT INTO "QuotaInformation"."UserRetribution" ("QuotaGains", "Retribution")
VALUES
    (
        100, 'Travaux forcés en usine de textile - unité : /kg de textile produit'
    ),
    (
        0.05, 'Transport du textile - unité : /km parcouru'
    ),
    (
        400, 'Culture du coton biologique - unité /kg recolté'
    ),
    (
        40, 'Vente d`un doigt'
    ),
    (
        175, 'Vente d`une main / pied'
    ),
    (
        250, 'Vente d`un avant-bras'
    ),
    (
        350, 'Vente d`un bras'
    ),
    (
        250, 'Vente d`un mollet'
    ),
    (
        450, 'Vente d`une jambe'
    )
ON CONFLICT ("Retribution") DO NOTHING;

-- City Retribution SCRIPT
INSERT INTO "QuotaInformation"."CityRetribution" ("TriggerPercentage", "Retribution")
VALUES
    (
        5, 'Public shaming'
    ),
    (
        10, 'Privation des aides de l’Etat'
    ),
    (
        20, 'Augmentation du prix du textile'
    )
ON CONFLICT ("Retribution") DO NOTHING;

-- Retribution Requirement SCRIPT
INSERT INTO "QuotaInformation"."RetributionRequirement" ("MinAge", "MaxAge")
VALUES
    (0, 12),
    (13, 99)
ON CONFLICT ("MaxAge") DO NOTHING;

-- Fabric Animal Origin

INSERT INTO "MarketInformation"."FabricAnimalOrigin" ("Name")
VALUES
    ('ANIMAL'), ('ORGANIC_VEGETATION'), ('OTHER')
ON CONFLICT ("Name") DO NOTHING;

-- Fabric

INSERT INTO "MarketInformation"."Fabric"
    ("Name", "WaterConsumptionCubicCentimeterPerGram",
     "KilogramCO2EquivalentPerSquareMetre", "FabricAnimalOriginId", "CountryId")
VALUES
    (
        ('LAINE'), 0.000883, 13.89,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'ANIMAL'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'AUSTRALIE')
    ),
    (
        ('COTON'), 0.05, 8.3,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE')
    ),
    (
        ('SYNTHETIQUE'), 0.000062, 6.4,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE')
    ),
    (
        ('CUIR_ANIMALE'), 0.000037, 110,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'ANIMAL'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE')
    ),
    (
        ('CUIR_VEGETAL'), 0.000037, 15.8,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BRESIL')
    ),
    (
        ('LYOCELL'), 0.001, 10.1,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'ETATS-UNIS')
    ),
    (
        ('LIN'), 0, 4.5,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'ORGANIC_VEGETATION'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE')
    )
ON CONFLICT ("Name") DO NOTHING;

-- Product Type SCRIPT
INSERT INTO "MarketInformation"."ProductType" ("Name")
VALUES ('T-SHIRT'), ('PULL'), ('PANTALON'), ('ROBE'), ('MANTEAU'), ('CHEMISE'), ('CHAUSSURE')
ON CONFLICT ("Name") DO NOTHING;

-- Product SCRIPT
INSERT INTO "MarketInformation"."Product" ("Name", "Area", "CountryId", "ProductTypeId", "Price", "Mass", "Description", "ProfilePicture")
VALUES
    (
        'Tee-Shirt', 0.48,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BANGLADESH'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'T-SHIRT'), 7.99, 150,
        'C`est un magnifique t-shirt !', 'picture.jpg'
    ),
    (
        'Pull', 0.61,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'TURQUIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PULL'), 25.99, 300,
        'C`est un magnifique pull !', 'picture.jpg'
    ),
    (
        'Jean droit-regular', 0.95,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'INDONESIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PANTALON'), 34.99, 800,
        'C`est un magnifique jean !', 'picture.jpg'
    ),
    (
        'Robe à effet drapé', 2.1,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BIRMANIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'ROBE'), 30, 200,
        'C`est une magnifique robe !', 'picture.jpg'
    ),
    (
        'Trench-coat', 2.1,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'MANTEAU'), 49.99, 600,
        'C`est un magnifique trench-coat !', 'picture.jpg'
    ),
    (
        'Manteau', 2.1,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'MANTEAU'), 78.99, 1200,
        'C`est un magnifique manteau !', 'picture.jpg'
    ),
    (
        'Chemise Blanche', 0.61,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'CHEMISE'), 25.99, 200,
        'C`est une magnifique chemise blanche !', 'picture.jpg'
    ),
    (
        'Chaussure en Cuir', 0.11932,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'CHAUSSURE'), 135, 800,
        'C`est une paire de chausse magnifique !', 'picture.jpg'
    ),
    (
        'Pantalon en Lin', 0.95,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PANTALON'), 145, 500,
        'C`est un magnifique pantalon en lin !', 'picture.jpg'
    )
ON CONFLICT ("Name") DO NOTHING;

-- Script Fabrics To Product
INSERT INTO "MarketInformation"."FabricsToProduct" ("ProductId", "FabricId", "Percentage")
VALUES
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Tee-Shirt'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'COTON'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Pull'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'SYNTHETIQUE'),
        94
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Pull'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'LAINE'),
        6
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Jean droit-regular'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'COTON'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Robe à effet drapé'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'SYNTHETIQUE'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Trench-coat'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'SYNTHETIQUE'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Manteau'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'LAINE'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Chemise Blanche'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'SYNTHETIQUE'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Chaussure en Cuir'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'CUIR_ANIMALE'),
        100
    ),
    (
        (SELECT "id" FROM "MarketInformation"."Product" WHERE "Name" = 'Pantalon en Lin'),
        (SELECT "id" FROM "MarketInformation"."Fabric" WHERE "Name" = 'LIN'),
        100
    )
ON CONFLICT ("ProductId", "FabricId") DO NOTHING;

-- Video Category SCRIPT
INSERT INTO "TrainingInformation"."VideoCategory" ("Name")
VALUES ('CREATION'), ('REUTILISATION'), ('RECYCLAGE')
ON CONFLICT DO NOTHING;

-- Training SCRIPT
INSERT INTO  "TrainingInformation"."Training" ("Name", "Video", "CategoryId", "Stars", "UserFullName", "UserPicture")
VALUES
    (
        ('Transformer son jean en jupe !'), ('https://www.youtube.com/shorts/7KuD4rLadfM'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'REUTILISATION'), 4,
        '@jorjadela', 'picture.jpg'
    ),
    (
        ('Transformer son jean en jupe !'), ('https://www.youtube.com/shorts/7KuD4rLadfM'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'REUTILISATION'), 4,
        '@jorjadela', 'picture.jpg'
    ),
    (
        ('Transformer son jean en jupe !'), ('https://www.youtube.com/shorts/7KuD4rLadfM'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'REUTILISATION'), 4,
        '@jorjadela', 'picture.jpg'
    ),
    (
        ('Transformer son jean en jupe !'), ('https://www.youtube.com/shorts/7KuD4rLadfM'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'REUTILISATION'), 4,
        '@jorjadela', 'picture.jpg'
    ),
    (
        ('5 idées chouettes pour réparer tes vêtements'), ('https://www.youtube.com/shorts/IA8jPZKqnjQ'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'RECYCLAGE'), 4,
        '@lorenfascianel', 'picture.jpg'
    ),
    (
        ('5 idées chouettes pour réparer tes vêtements'), ('https://www.youtube.com/shorts/IA8jPZKqnjQ'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'RECYCLAGE'), 4,
        '@lorenfascianel', 'picture.jpg'
    ),
    (
        ('5 idées chouettes pour réparer tes vêtements'), ('https://www.youtube.com/shorts/IA8jPZKqnjQ'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'RECYCLAGE'), 4,
        '@lorenfascianel', 'picture.jpg'
    ),
    (
        ('Créer ses propres vêtements ! (Patrons, couture & essayages)'), ('https://www.youtube.com/watch?v=SQAG7Chpbvw'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'CREATION'), 4,
        '@CarlotaMakeup', 'picture.jpg'
    ),
    (
        ('Créer ses propres vêtements ! (Patrons, couture & essayages)'), ('https://www.youtube.com/watch?v=SQAG7Chpbvw'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'CREATION'), 4,
        '@CarlotaMakeup', 'picture.jpg'
    ),
    (
        ('Créer ses propres vêtements ! (Patrons, couture & essayages)'), ('https://www.youtube.com/watch?v=SQAG7Chpbvw'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'CREATION'), 4,
        '@CarlotaMakeup', 'picture.jpg'
    ),
    (
        ('Créer ses propres vêtements ! (Patrons, couture & essayages)'), ('https://www.youtube.com/watch?v=SQAG7Chpbvw'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'CREATION'), 4,
        '@CarlotaMakeup', 'picture.jpg'
    ),
    (
        ('Créer ses propres vêtements ! (Patrons, couture & essayages)'), ('https://www.youtube.com/watch?v=SQAG7Chpbvw'),
        (SELECT "id" FROM "TrainingInformation"."VideoCategory" WHERE "VideoCategory"."Name" = 'CREATION'), 4,
        '@CarlotaMakeup', 'picture.jpg'
    )
ON CONFLICT DO NOTHING;