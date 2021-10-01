-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 11, 2020 at 03:36 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `event`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'Pranavan', '123');

-- --------------------------------------------------------

--
-- Table structure for table `caterings`
--

CREATE TABLE `entertainment` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(200) DEFAULT NULL,
  `typeOfEntertainment` varchar(20) NOT NULL,
  `days` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `caterings`
--

INSERT INTO `caterings` (`id`, `resourcename`, `typeOfEntertainment`, `days`, `Location`, `filename`, `path`) VALUES
(13, 'Kajal dj Nights', 'audio,Dinner', 'Weekend', 'Malabe', 'Deluxe-Room-at-Yara-Galle-Fort.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\RoomImg\\Deluxe-Room-at-Yara-Galle-Fort.jpg'),
(14, 'Vicky memicry Show', 'audio', 'Tv , Ac , Weekdays ', 'Kandy', 'images.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\RoomImg\\images.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `cateringsbooking`
--

CREATE TABLE `entertainmentbooking` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(100) NOT NULL,
  `typeOfEntertainment` varchar(15) NOT NULL,
  `days` int(11) NOT NULL,
  `location` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `additionalneeds` varchar(60) NOT NULL,
  `advancedpayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cateringsbooking`
--

INSERT INTO `entertainmentbooking` (`id`, `resourcename`, `typeOfEntertainment`, `days`, `location`, `bookingdate`, `additionalneeds`, `advancedpayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', 'DJ nights',  10000),
(4, 'Janu', '9528439936V,', 778954562, 'wurifimun@mailinator.com', '22-06-2019', 'DJ nights',  7500),
(5, 'Kriti', '9992839936V', 778954562, 'pyxe@mailinator.com', '1974-11-28', 'DJ nights',  22000),
(6, 'Shaan', '9702333936V', 778954562, 'np@gmail.com', '25-06-2019', 'DJ nights',  5000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullname` varchar(600) NOT NULL,
  `username` varchar(60) NOT NULL,
  `mobile` int(12) NOT NULL,
  `address` varchar(600) NOT NULL,
  `mail` varchar(600) NOT NULL,
  `password` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fullname`, `username`, `mobile`, `address`, `mail`, `password`) VALUES
(1, 'Prana', 'Pranavan', 772654544, 'jaffna', 'np@gmail.com', '1234'),
(2, 'Allistair Randall', 'raja', 55, 'Qui dolore est sint', 'asd@gmail.com', '1234 ');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(3) NOT NULL,
  `name` varchar(120) NOT NULL,
  `email` varchar(220) NOT NULL,
  `country` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `caterings`
--
ALTER TABLE `entertainment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cateringsbooking`
--
ALTER TABLE `entertainmentbooking`
  ADD PRIMARY KEY (`id`);


--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `caterings`
--
ALTER TABLE `entertainment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `cateringsbooking`
--
ALTER TABLE `entertainmentbooking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
