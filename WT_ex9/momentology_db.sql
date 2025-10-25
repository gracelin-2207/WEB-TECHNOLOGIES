-- Momentology Studio Database Dump
CREATE DATABASE IF NOT EXISTS momentology_db;
USE momentology_db;

-- Table: portfolio
CREATE TABLE IF NOT EXISTS portfolio (
  PhotoID INT AUTO_INCREMENT PRIMARY KEY,
  Title VARCHAR(100),
  Category VARCHAR(50),
  Client VARCHAR(100),
  Rating DOUBLE
);

INSERT INTO portfolio (Title, Category, Client, Rating) VALUES
('Golden Hour Portraits', 'Portrait', 'Luxe Studio', 4.8),
('Eternal Moments Wedding', 'Wedding', 'Amara & Ryan', 4.9),
('Bold Brand Launch', 'Branding', 'Nova Apparel', 4.7),
('Product Aesthetics Shoot', 'Product', 'Glow Cosmetics', 4.6),
('Dreamscape Bridal', 'Wedding', 'Evelyn & Cole', 4.9);

-- Table: brand_info
CREATE TABLE IF NOT EXISTS brand_info (
  BrandID VARCHAR(10) PRIMARY KEY,
  BrandName VARCHAR(100),
  Projects INT
);

INSERT INTO brand_info (BrandID, BrandName, Projects) VALUES
('B101', 'Nova Apparel', 5),
('B102', 'Glow Cosmetics', 3),
('B103', 'Amara Weddings', 7),
('B104', 'Luxe Studio', 4),
('B105', 'Urban Frames', 2);
