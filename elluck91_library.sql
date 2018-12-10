-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 09, 2018 at 12:19 AM
-- Server version: 8.0.13
-- PHP Version: 7.2.10-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elluck91_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `amenity`
--

CREATE TABLE `amenity` (
  `amenityID` int(11) NOT NULL,
  `amenityName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `amenity`
--

INSERT INTO `amenity` (`amenityID`, `amenityName`) VALUES
(0, 'Elevator'),
(1, 'Free parking'),
(2, 'Kitchen'),
(3, 'Wifi'),
(4, 'Dryer'),
(5, 'TV'),
(6, 'AC');

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `billingID` int(10) NOT NULL,
  `cardNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` char(2) NOT NULL,
  `zip` int(5) NOT NULL,
  `guestID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`billingID`, `cardNumber`, `address`, `city`, `state`, `zip`, `guestID`) VALUES
(1, '1234567890123456', '123', '123', '12', 12345, 1);

-- --------------------------------------------------------

--
-- Table structure for table `description`
--

CREATE TABLE `description` (
  `descriptionID` int(11) NOT NULL,
  `amenityCode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `description`
--

INSERT INTO `description` (`descriptionID`, `amenityCode`) VALUES
(1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `guestID` int(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`guestID`, `name`, `email`, `password`) VALUES
(1, 'Lukasz', 'kukasz', 'ukasz'),
(2, 'Kasia', 'kasia@gmail.com', 'abc123'),
(3, 'Kasia', 'kasia1@gmail.com', 'abc123'),
(4, 'Kasia', 'kasia430@gmail.com', 'abc123'),
(5, 'Kasia', 'kasia147@gmail.com', 'abc123'),
(6, 'Kasia', 'kasia628@gmail.com', 'abc123'),
(7, 'Kasia', 'kasia700@gmail.com', 'abc123'),
(8, 'Kasia', 'kasia617@gmail.com', 'abc123'),
(9, 'Kasia', 'kasia984@gmail.com', 'abc123'),
(10, 'Kasia', 'kasia72@gmail.com', 'abc123'),
(11, 'Kasia', 'kasia410@gmail.com', 'abc123'),
(12, 'Kasia', 'kasia831@gmail.com', 'abc123'),
(13, 'Kasia', 'kasia925@gmail.com', 'abc123'),
(14, 'Kasia', 'kasia135@gmail.com', 'abc123'),
(15, 'Kasia', 'kasia900@gmail.com', 'abc123'),
(16, 'Kasia', 'kasia93@gmail.com', 'abc123'),
(17, 'Kasia', 'kasia769@gmail.com', 'abc123'),
(18, 'Kasia', 'kasia564@gmail.com', 'abc123'),
(19, 'Kasia', 'kasia515@gmail.com', 'abc123'),
(20, 'Kasia', 'kasia884@gmail.com', 'abc123'),
(21, 'Kasia', 'kasia876@gmail.com', 'abc123'),
(22, 'Kasia', 'kasia726@gmail.com', 'abc123'),
(23, 'Kasia', 'kasia5@gmail.com', 'abc123'),
(24, 'Kasia', 'kasia845@gmail.com', 'abc123'),
(25, 'Kasia', 'kasia214@gmail.com', 'abc123'),
(26, 'Kasia', 'kasia532@gmail.com', 'abc123'),
(27, 'Kasia', 'kasia20@gmail.com', 'abc123'),
(28, 'Kasia', 'kasia506@gmail.com', 'abc123'),
(29, 'Kasia', 'kasia468@gmail.com', 'abc123'),
(30, 'Kasia', 'kasia825@gmail.com', 'abc123'),
(31, 'Kasia', 'kasia720@gmail.com', 'abc123'),
(32, 'Kasia', 'kasia124@gmail.com', 'abc123'),
(33, 'Kasia', 'kasia461@gmail.com', 'abc123'),
(34, 'Kasia', 'kasia934@gmail.com', 'abc123'),
(35, 'Kasia', 'kasia286@gmail.com', 'abc123'),
(36, 'Kasia', 'kasia630@gmail.com', 'abc123'),
(37, 'Kasia', 'kasia294@gmail.com', 'abc123'),
(38, 'Kasia', 'kasia579@gmail.com', 'abc123'),
(39, 'Kasia', 'kasia14@gmail.com', 'abc123'),
(40, 'Kasia', 'kasia332@gmail.com', 'abc123'),
(41, 'Kasia', 'kasia621@gmail.com', 'abc123'),
(42, 'Kasia', 'kasia110@gmail.com', 'abc123'),
(43, 'Kasia', 'kasia685@gmail.com', 'abc123'),
(44, 'Kasia', 'kasia96@gmail.com', 'abc123'),
(45, 'Kasia', 'kasia425@gmail.com', 'abc123'),
(46, 'Kasia', 'kasia838@gmail.com', 'abc123'),
(47, 'Kasia', 'kasia918@gmail.com', 'abc123'),
(48, 'Kasia', 'kasia73@gmail.com', 'abc123');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `hotelID` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(14) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` char(2) NOT NULL,
  `zip` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`hotelID`, `name`, `phone`, `address`, `city`, `state`, `zip`) VALUES
(1, 'one', '1234567890', '123', '123', 'CA', 12345),
(2, 'De Anza Hotel', '(408) 286-1000', '233 W Santa Clara St', 'San Jose', 'CA', 95113),
(3, 'San Jose Marriott', '(408) 280-1300', '301 S Market St', 'San Jose', 'CA', 95113),
(4, 'Fairmont San Jose', '(408) 998-1900', '170 S Market St', 'San Jose', 'CA', 95113);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservationID` int(10) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `roomID` int(10) NOT NULL,
  `guestID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservationID`, `startDate`, `endDate`, `roomID`, `guestID`) VALUES
(4, '2018-06-22', '2018-06-24', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomID` int(10) NOT NULL,
  `roomNumber` int(10) NOT NULL,
  `rate` decimal(6,2) DEFAULT NULL,
  `hotelID` int(10) DEFAULT NULL,
  `amenityID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomID`, `roomNumber`, `rate`, `hotelID`, `amenityID`) VALUES
(0, 28, '42.00', 2, 0),
(1, 1, '69.99', 1, 0),
(2, 2, '70.00', 1, 0),
(3, 3, '80.00', 1, 0),
(4, 4, '100.00', 1, 0),
(5, 1, '68.00', 2, 0),
(6, 44, '2.00', 4, 0),
(7, 75, '53.00', 2, 0),
(9, 24, '96.00', 1, 0),
(20, 91, '94.00', 4, 0),
(50, 74, '22.00', 4, 0),
(52, 53, '9.00', 4, 0),
(55, 36, '14.00', 3, 0),
(61, 87, '53.00', 1, 0),
(64, 5, '34.00', 3, 0),
(67, 77, '84.00', 4, 0),
(68, 56, '79.00', 2, 0),
(79, 14, '32.00', 1, 0),
(80, 31, '14.00', 4, 0),
(85, 28, '88.00', 3, 0),
(91, 15, '6.00', 4, 0),
(96, 37, '97.00', 4, 0),
(196, 78, '88.00', 1, 0),
(558, 40, '85.00', 1, 0),
(757, 81, '86.00', 4, 0),
(1110, 84, '91.00', 1, 0),
(1347, 28, '2.00', 2, 0),
(1392, 27, '97.00', 1, 0),
(1475, 42, '69.00', 1, 0),
(1893, 80, '47.00', 4, 0),
(1978, 96, '24.00', 2, 0),
(1994, 50, '93.00', 1, 0),
(2129, 94, '8.00', 3, 0),
(2297, 34, '1.00', 1, 0),
(2420, 8, '70.00', 2, 0),
(2504, 45, '53.00', 2, 0),
(2632, 52, '82.00', 3, 0),
(2679, 84, '40.00', 2, 0),
(2993, 35, '90.00', 2, 0),
(3414, 84, '20.00', 2, 0),
(3472, 3, '15.00', 3, 0),
(3482, 76, '78.00', 3, 0),
(3580, 73, '58.00', 3, 0),
(3720, 48, '30.00', 1, 0),
(3765, 40, '87.00', 1, 0),
(3910, 67, '20.00', 4, 0),
(4104, 78, '69.00', 1, 0),
(4124, 55, '55.00', 1, 0),
(4723, 11, '17.00', 3, 0),
(4932, 15, '31.00', 1, 0),
(4961, 79, '49.00', 1, 0),
(5037, 29, '98.00', 1, 0),
(5149, 31, '0.00', 1, 0),
(5250, 25, '71.00', 4, 0),
(5272, 63, '59.00', 1, 0),
(5279, 45, '69.00', 1, 0),
(5438, 53, '5.00', 3, 0),
(5647, 69, '79.00', 4, 0),
(5963, 96, '4.00', 2, 0),
(6602, 74, '74.00', 2, 0),
(6798, 23, '14.00', 1, 0),
(6951, 67, '31.00', 3, 0),
(7048, 6, '19.00', 4, 0),
(7103, 97, '73.00', 3, 0),
(7155, 48, '25.00', 4, 0),
(7426, 91, '32.00', 4, 0),
(7628, 61, '79.00', 1, 0),
(7704, 97, '57.00', 4, 0),
(7819, 47, '3.00', 3, 0),
(7874, 67, '98.00', 4, 0),
(7958, 2, '73.00', 3, 0),
(7986, 8, '0.00', 4, 0),
(8112, 92, '18.00', 1, 0),
(8140, 53, '24.00', 3, 0),
(8277, 34, '22.00', 1, 0),
(8351, 78, '44.00', 4, 0),
(8480, 40, '47.00', 1, 0),
(9130, 20, '28.00', 4, 0),
(9194, 23, '41.00', 2, 0),
(9296, 9, '66.00', 1, 0),
(9879, 97, '92.00', 3, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenity`
--
ALTER TABLE `amenity`
  ADD PRIMARY KEY (`amenityID`);

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`billingID`),
  ADD KEY `guest2` (`guestID`);

--
-- Indexes for table `description`
--
ALTER TABLE `description`
  ADD PRIMARY KEY (`descriptionID`);

--
-- Indexes for table `guest`
--
ALTER TABLE `guest`
  ADD PRIMARY KEY (`guestID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotelID`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservationID`),
  ADD KEY `roomID` (`roomID`),
  ADD KEY `guest` (`guestID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomID`),
  ADD KEY `deleteRoom` (`hotelID`),
  ADD KEY `amenityForeignKey` (`amenityID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `billingID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `guest`
--
ALTER TABLE `guest`
  MODIFY `guestID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservationID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `billing`
--
ALTER TABLE `billing`
  ADD CONSTRAINT `guest2` FOREIGN KEY (`guestID`) REFERENCES `guest` (`guestid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `guest` FOREIGN KEY (`guestID`) REFERENCES `guest` (`guestid`) ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`roomID`) REFERENCES `room` (`roomid`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `amenityForeignKey` FOREIGN KEY (`amenityID`) REFERENCES `amenity` (`amenityid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `deleteRoom` FOREIGN KEY (`hotelID`) REFERENCES `hotel` (`hotelid`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
