-- UserInformation schema
CREATE TABLE "UserInformation"."Country" (
                                             "id" SERIAL PRIMARY KEY,
                                             "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "UserInformation"."City" (
                                          "id" SERIAL PRIMARY KEY,
                                          "Name" VARCHAR NOT NULL UNIQUE,
                                          "CountryId" INT NOT NULL,
                                          FOREIGN KEY ("CountryId") REFERENCES "UserInformation"."Country"("id")
);

CREATE TABLE "UserInformation"."User" (
                                          "id" SERIAL PRIMARY KEY,
                                          "Name" VARCHAR NOT NULL,
                                          "Lastname" VARCHAR NOT NULL,
                                          "CityId" INT NOT NULL,
                                          "Birthdate" TIMESTAMP NOT NULL,
                                          "QuotaId" INT NOT NULL,
                                          "ProfilePicture" BYTEA NOT NULL,
                                          FOREIGN KEY ("CityId") REFERENCES "UserInformation"."City"("id")
);

CREATE TABLE "UserInformation"."Family" (
                                             "id" SERIAL PRIMARY KEY,
                                             "Address" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "UserInformation"."UserToFamily" (
                                                   "id" SERIAL PRIMARY KEY,
                                                   "UserId" INT NOT NULL UNIQUE,
                                                   "FamilyId" INT NOT NULL,
                                                   FOREIGN KEY ("UserId") REFERENCES "UserInformation"."User"("id"),
                                                   FOREIGN KEY ("FamilyId") REFERENCES "UserInformation"."Family"("id")
);

CREATE TABLE "UserInformation"."Invoice" (
                                             "id" SERIAL PRIMARY KEY,
                                             "Date" TIMESTAMP NOT NULL,
                                             "Quota" INT NOT NULL,
                                             "UserId" INT NOT NULL,
                                             FOREIGN KEY ("UserId") REFERENCES "UserInformation"."User"("id")
);

CREATE TABLE "UserInformation"."TIGInfrastructure" (
                                                       "id" SERIAL PRIMARY KEY,
                                                       "Name" VARCHAR NOT NULL,
                                                       "CityId" INT NOT NULL,
                                                       FOREIGN KEY ("CityId") REFERENCES "UserInformation"."City"("id")
);

-- MarketInformation schema
CREATE TABLE "MarketInformation"."Product" (
                                               "id" SERIAL PRIMARY KEY,
                                               "Name" VARCHAR NOT NULL UNIQUE
);

CREATE TABLE "MarketInformation"."Fabric" (
                                              "id" SERIAL PRIMARY KEY,
                                              "Name" VARCHAR NOT NULL UNIQUE,
                                              "CostPerGram" INT NOT NULL
);

CREATE TABLE "MarketInformation"."FabricsToProduct" (
                                                        "id" SERIAL PRIMARY KEY,
                                                        "ProductId" INT NOT NULL,
                                                        "FabricId" INT NOT NULL,
                                                        FOREIGN KEY ("ProductId") REFERENCES "MarketInformation"."Product"("id"),
                                                        FOREIGN KEY ("FabricId") REFERENCES "MarketInformation"."Fabric"("id")
);

-- QuotaInformation schema
CREATE TABLE "QuotaInformation"."UserRetribution" (
                                                  "id"         SERIAL PRIMARY KEY,
                                                  "QuotaGains" INT NOT NULL,
                                                  "Retribution" VARCHAR NOT NULL UNIQUE
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
                                                     FOREIGN KEY ("PunishmentRequirementId") REFERENCES "QuotaInformation"."RetributionRequirement"("id")
);