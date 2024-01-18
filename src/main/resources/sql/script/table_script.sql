-- MarketInformation schema
DROP SCHEMA IF EXISTS "MarketInformation" CASCADE;
CREATE SCHEMA "MarketInformation";

CREATE TABLE "MarketInformation"."ProductType" (
                                                   "id" SERIAL PRIMARY KEY,
                                                   "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "MarketInformation"."Product" (
                                               "id" SERIAL PRIMARY KEY,
                                               "Name" VARCHAR NOT NULL UNIQUE,
                                               "Area" FLOAT NOT NULL,
                                               "IsSecondHand" BOOLEAN NOT NULL DEFAULT FALSE,
                                               "IsSold" BOOLEAN NOT NULL DEFAULT FALSE,
                                               "CountryId" INT NOT NULL,
                                               "ProductTypeId" INT NOT NULL,
                                               "Price" FLOAT NOT NULL,
                                               "Mass" FLOAT NOT NULL,
                                               "Description" VARCHAR NOT NULL,
                                               "ProfilePicture" BYTEA NOT NULL,
                                               FOREIGN KEY ("ProductTypeId") REFERENCES "MarketInformation"."ProductType" ("id"),
                                               FOREIGN KEY ("CountryId") REFERENCES "UserInformation"."Country" ("id")
);

CREATE TABLE "MarketInformation"."FabricAnimalOrigin" (
                                                          "id" SERIAL PRIMARY KEY,
                                                          "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "MarketInformation"."Fabric" (
                                              "id" SERIAL PRIMARY KEY,
                                              "Name" VARCHAR NOT NULL UNIQUE,
                                              "WaterConsumptionCubicCentimeterPerGram" FLOAT NOT NULL,
                                              "KilogramCO2EquivalentPerSquareMetre" FLOAT NOT NULL,
                                              "FabricAnimalOriginId" INT NOT NULL,
                                              "CountryId" INT NOT NULL,
                                              FOREIGN KEY ("CountryId") REFERENCES "UserInformation"."Country" ("id"),
                                              FOREIGN KEY ("FabricAnimalOriginId") REFERENCES "MarketInformation"."FabricAnimalOrigin" ("id")
);

CREATE TABLE "MarketInformation"."FabricsToProduct" (
                                                        "id" SERIAL PRIMARY KEY,
                                                        "ProductId" INT NOT NULL,
                                                        "FabricId" INT NOT NULL,
                                                        "Percentage" INT NOT NULL,
                                                        FOREIGN KEY ("ProductId") REFERENCES "MarketInformation"."Product" ("id"),
                                                        FOREIGN KEY ("FabricId") REFERENCES "MarketInformation"."Fabric" ("id")
);

ALTER TABLE "MarketInformation"."FabricsToProduct" ADD CONSTRAINT "unique_product_fabric_combination" UNIQUE ("ProductId", "FabricId");

-- QuotaInformation schema
DROP SCHEMA IF EXISTS "QuotaInformation" CASCADE ;
CREATE SCHEMA "QuotaInformation";

CREATE TABLE "QuotaInformation"."UserRetribution" (
                                                      "id"         SERIAL PRIMARY KEY,
                                                      "QuotaGains" INT NOT NULL,
                                                      "Retribution" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "QuotaInformation"."CityRetribution" (
                                                      "id" SERIAL PRIMARY KEY,
                                                      "Retribution" VARCHAR NOT NULL UNIQUE,
                                                      "TriggerPercentage" int NOT NULL UNIQUE
);

CREATE TABLE "QuotaInformation"."RetributionRequirement" (
                                                             "id" SERIAL PRIMARY KEY,
                                                             "MinAge" INT NOT NULL UNIQUE,
                                                             "MaxAge" INT NOT NULL UNIQUE
);

CREATE TABLE "QuotaInformation"."Quota" (
                                            "id" SERIAL PRIMARY KEY,
                                            "PunishmentRequirementId" INT NOT NULL,
                                            "MaxQuotaQuarterly" INT NOT NULL,
                                            FOREIGN KEY ("PunishmentRequirementId") REFERENCES "QuotaInformation"."RetributionRequirement" ("id")
);

CREATE TABLE "QuotaInformation"."ProductCostCoefficient" (
                                                             "id" SERIAL PRIMARY KEY,
                                                             "Name" VARCHAR NOT NULL UNIQUE,
                                                             "PenaltyCoefficient" FLOAT NOT NULL
);

-- UserInformation schema
DROP SCHEMA IF EXISTS "UserInformation" CASCADE;
CREATE SCHEMA "UserInformation";

CREATE TABLE "UserInformation"."Country" (
                                             "id" SERIAL PRIMARY KEY,
                                             "Name" VARCHAR NOT NULL UNIQUE,
                                             "Lat" FLOAT NOT NULL UNIQUE,
                                             "Lon" FLOAT NOT NULL UNIQUE
);

CREATE TABLE "UserInformation"."City" (
                                          "id" SERIAL PRIMARY KEY,
                                          "Name" VARCHAR NOT NULL UNIQUE,
                                          "CountryId" INT NOT NULL,
                                          FOREIGN KEY ("CountryId") REFERENCES "UserInformation"."Country" ("id")
);

CREATE TABLE "UserInformation"."Role" (
                                          "id" SERIAL PRIMARY KEY,
                                          "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "UserInformation"."Authority" (
                                               "id" SERIAL PRIMARY KEY,
                                               "Username" VARCHAR NOT NULL UNIQUE,
                                               "RoleId" int NOT NULL,
                                               "Password" VARCHAR NOT NULL,
                                               FOREIGN KEY ("RoleId") REFERENCES "UserInformation"."Role" ("id")
);

CREATE TABLE "UserInformation"."Family" (
                                            "id" SERIAL PRIMARY KEY,
                                            "Address" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "UserInformation"."User" (
                                          "id" SERIAL PRIMARY KEY,
                                          "Name" VARCHAR NOT NULL,
                                          "Lastname" VARCHAR NOT NULL,
                                          "CityId" INT NOT NULL,
                                          "Birthdate" TIMESTAMP NOT NULL,
                                          "QuotaId" INT,
                                          "ProfilePicture" BYTEA NOT NULL,
                                          "Gender" VARCHAR NOT NULL,
                                          "AuthorityId" int NOT NULL UNIQUE,
                                          "FamilyId" INT,
                                          FOREIGN KEY ("CityId") REFERENCES "UserInformation"."City" ("id"),
                                          FOREIGN KEY ("FamilyId") REFERENCES "UserInformation"."Family" ("id"),
                                          FOREIGN KEY ("AuthorityId") REFERENCES "UserInformation"."Authority" ("id"),
                                          FOREIGN KEY ("QuotaId") REFERENCES "QuotaInformation"."Quota" ("id")
);

CREATE TABLE "UserInformation"."Invoice" (
                                             "id" SERIAL PRIMARY KEY,
                                             "Date" TIMESTAMP NOT NULL,
                                             "Quota" INT NOT NULL,
                                             "UserId" INT NOT NULL,
                                             "ProductTypeId" INT NOT NULL,
                                             "ProductPrice" FLOAT NOT NULL,
                                             FOREIGN KEY ("ProductTypeId") REFERENCES "MarketInformation"."ProductType" ("id"),
                                             FOREIGN KEY ("UserId") REFERENCES "UserInformation"."User" ("id")
);

CREATE TABLE "UserInformation"."TIGInfrastructure" (
                                                       "id" SERIAL PRIMARY KEY,
                                                       "Name" VARCHAR NOT NULL UNIQUE,
                                                       "CityId" INT NOT NULL,
                                                       FOREIGN KEY ("CityId") REFERENCES "UserInformation"."City" ("id")
);

-- TrainingInformation schema
DROP SCHEMA IF EXISTS "TrainingInformation" CASCADE;
CREATE SCHEMA "TrainingInformation";

CREATE TABLE "TrainingInformation"."VideoCategory" (
                                                       "id" SERIAL PRIMARY KEY,
                                                       "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "TrainingInformation"."Training" (
                                                  "id" SERIAL PRIMARY KEY,
                                                  "Name" VARCHAR NOT NULL UNIQUE,
                                                  "Video" VARCHAR NOT NULL,
                                                  "CategoryId" INT NOT NULL,
                                                  "Stars" INT NOT NULL,
                                                  "UserFullName" VARCHAR NOT NULL,
                                                  "UserPicture" BYTEA NOT NULL,
                                                  FOREIGN KEY ("CategoryId") REFERENCES "TrainingInformation"."VideoCategory" ("id")
);
