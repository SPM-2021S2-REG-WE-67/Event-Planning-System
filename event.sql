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
-- Database: `hotel`
--

-- --------------------------------------------------------


--

CREATE TABLE `entertainment` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(200) DEFAULT NULL,
  `typeofentertainment` varchar(20) NOT NULL,
  `workingdays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `entertainment` (`id`, `resourcename`, `typeofentertainment`, `workingdays`, `Location`, `filename`, `path`) VALUES
(13, 'thulasi studio', 'photgraphy', 'weekdays', 'jaffna', 'Deluxe-Room-at-Yara-Galle-Fort.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\RoomImg\\Deluxe-Room-at-Yara-Galle-Fort.jpg'),
(14, 'kannan studio studio', 'videgraphy', 'weekdays', 'colombo', 'images.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\RoomImg\\images.jpg'),
(15, 'malar  studio', 'photgraphy', 'weekend', 'battcaloa', '205684046.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\RoomImg\\205684046.jpg'),

-- --------------------------------------------------------

--
-- Table structure for table `entertatinment`
--




--

--
ALTER TABLE `entertainment`
  ADD PRIMARY KEY (`id`);

--

--

--
-- AUTO_INCREMENT for dumped tables
--
--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `entertainment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
