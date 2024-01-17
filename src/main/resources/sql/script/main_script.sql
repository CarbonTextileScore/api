-- Country SCRIPT
INSERT INTO "UserInformation"."Country" ("Name")
VALUES ('FRANCE'), ('PAKISTAN'), ('BANGLADESH')
ON CONFLICT ("Name") DO NOTHING;

-- City SCRIPT
INSERT INTO "UserInformation"."City" ("Name", "CountryId")
VALUES ('CAEN', (
    SELECT "id" FROM "UserInformation"."Country" WHERE "Name" = 'FRANCE'
)
       )
ON CONFLICT ("Name") DO NOTHING;

-- TIGInfrastructure SCRIPT
INSERT INTO "UserInformation"."TIGInfrastructure" ("Name", "CityId")
VALUES (('TIG_CAEN'), (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'))
ON CONFLICT ("Name") DO NOTHING;

-- Role SCRIPT
INSERT INTO "UserInformation"."Role" ("Name")
VALUES ('ROLE_USER'), ('ROLE_CITY'), ('ROLE_COUNTRY')
ON CONFLICT ("Name") DO NOTHING;

-- Authority SCRIPT
INSERT INTO "UserInformation"."Authority" ("Username", "RoleId", "Password")
VALUES (
        'TAN',
        (SELECT "id" FROM "UserInformation"."Role" WHERE "Name" = 'ROLE_USER'),
        'TMP'
       )
ON CONFLICT ("Username") DO NOTHING;

-- USer SCRIPT
INSERT INTO "UserInformation"."User" ("Name", "Lastname", "CityId", "Birthdate", "QuotaId", "ProfilePicture", "Gender", "AuthorityId")
VALUES (
        'Tangui',
        'STEIMETZ',
        (SELECT "id" FROM "UserInformation"."City" WHERE "City"."Name" = 'CAEN'),
        TO_TIMESTAMP('2016-09-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
        null,
        'profile_picture.jpg',
        'M',
        (SELECT "id" FROM "UserInformation"."Authority" WHERE "Username" = 'TAN')
       )
ON CONFLICT ("AuthorityId") DO NOTHING;