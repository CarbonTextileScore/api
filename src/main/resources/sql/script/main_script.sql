-- Country SCRIPT
INSERT INTO "UserInformation"."Country" ("Name", "Lon", "Lat")
VALUES
    ('FRANCE', 2.3522, 48.8566),
    ('PAKISTAN', 73.0479, 33.6844 ),
    ('BANGLADESH', 90.4125, 23.8103),
    ('CHINE', 116.4074, 39.9042)
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
    ),
    (
        'testing'
    )
ON CONFLICT ("Address") DO NOTHING;

-- User SCRIPT
INSERT INTO "UserInformation"."User" ("Name", "Lastname", "CityId", "Birthdate", "QuotaId", "ProfilePicture", "Gender", "AuthorityId", "FamilyId")
VALUES
    (
        'Tangui',
        'STEIMETZ',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2016-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
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
        TO_TIMESTAMP('2016-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
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
    (
     0, 12
    ),
    (
     13, 99
    )
ON CONFLICT ("MinAge", "MaxAge") DO NOTHING;


-- Fabric Animal Origin
/*
INSERT INTO "MarketInformation"."FabricAnimalOrigin" ("Name")
VALUES
    ('ANIMAL'), ('ORGANIC_VEGETATION'), ('ORGANIC_AND_HIGHLY_MANUFACTURED')
ON CONFLICT ("Name") DO NOTHING;

-- Fabric Territorial Origin
INSERT INTO "MarketInformation"."FabricTerritorialOrigin" ("CountryId")
VALUES
    ()

 */
