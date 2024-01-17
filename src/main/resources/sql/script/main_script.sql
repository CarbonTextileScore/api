-- Country SCRIPT
INSERT INTO "UserInformation"."Country" ("Name")
VALUES ('FRANCE'), ('PAKISTAN'), ('BANGLADESH'), ('CHINE')
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
VALUES ('3 Esp. Stéphane Hessel, 14000 Caen')
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

