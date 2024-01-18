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
        'Maire',
        'CAEN',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2016-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
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
        TO_TIMESTAMP('2016-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
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
        100, 'Travaux forcés en usine de textile - Réparer une pièce'
    ),
    (
        50, 'Travaux forcés en usine de textile - 4h couture à la chaîne'
    ),
    (
        100, 'Travaux forcés en usine de textile - 8h couture à la chaîne'
    ),
    (
        200, 'Travaux forcés en usine de textile - 12h couture à la chaîne'
    ),
    (
        50, 'Vente d`un doigt'
    ),
    (
        250, 'Vente d`une main / pied'
    ),
    (
        300, 'Vente d`un avant-bras'
    ),
    (
        500, 'Vente d`un bras'
    ),
    (
        300, 'Vente d`un mollet'
    ),
    (
        800, 'Vente d`une jambe'
    ),
    (
        500, 'Utilisation des corps A à Z'
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
        ('LAINE'), 883, 13.89,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'ANIMAL'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'AUSTRALIE')
    ),
    (
        ('COTON'), 50000, 8.3,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE')
    ),
    (
        ('SYNTHETIQUE'), 62, 6.4,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE')
    ),
    (
        ('CUIR_ANIMALE'), 37, 110,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'ANIMAL'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE')
    ),
    (
        ('CUIR_VEGETAL'), 37, 15.8,
        (SELECT "id" FROM "MarketInformation"."FabricAnimalOrigin" WHERE "FabricAnimalOrigin"."Name" = 'OTHER'),
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BRESIL')
    ),
    (
        ('LYOCELL'), 1000, 10.1,
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
INSERT INTO "MarketInformation"."Product" ("Name", "Area", "CountryId", "ProductTypeId", "Price", "Mass")
VALUES
    (
        'Tee-Shirt', 4800,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BANGLADESH'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'T-SHIRT'), 7.99, 150
    ),
    (
        'Pull', 6100,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'TURQUIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PULL'), 25.99, 300
    ),
    (
        'Jean droit-regular', 9500,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'INDONESIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PANTALON'), 34.99, 800
    ),
    (
        'Robe à effet drapé', 21000,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'BIRMANIE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'ROBE'), 30, 200
    ),
    (
        'Trench-coat', 21000,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'MANTEAU'), 49.99, 600
    ),
    (
        'Manteau', 21000,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'MANTEAU'), 78.99, 1200
    ),
    (
        'Chemise Blanche', 6100,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'CHINE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'CHEMISE'), 25.99, 200
    ),
    (
        'Chaussure en Cuir', 1193.2,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'CHAUSSURE'), 135, 800
    ),
    (
        'Pantalon en Lin', 9500,
        (SELECT "id" FROM "UserInformation"."Country" WHERE "Country"."Name" = 'FRANCE'),
        (SELECT "id" FROM "MarketInformation"."ProductType" WHERE "ProductType"."Name" = 'PANTALON'), 145, 500
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



