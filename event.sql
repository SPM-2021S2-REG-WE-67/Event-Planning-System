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
(1, 'Admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `caterings`
--

CREATE TABLE `caterings` (
  `id` int(11) NOT NULL,
  `cateringname` varchar(200) DEFAULT NULL,
  `CateringMenuDetails` varchar(20) NOT NULL,
  `WorkingDays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `caterings`
--

INSERT INTO `caterings` (`id`, `cateringname`, `CateringMenuDetails`, `WorkingDays`, `Location`, `filename`, `path`) VALUES
(13, 'Amirtha Caterings', 'Breakfast,Dinner', 'Weekend', 'Malabe', 'catering1.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\catering1.jpg'),
(14, 'Party Caterings', 'Dinner' , 'Weekdays ', 'Kandy', 'catering2.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\catering2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `cateringsbooking`
--

CREATE TABLE `cateringsbooking` (
  `id` int(11) NOT NULL,
  `User` varchar(100) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `additionalneeds` varchar(60) NOT NULL,
  `noofplates` int(11) NOT NULL,
  `advancedpayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cateringsbooking`
--

INSERT INTO `cateringsbooking` (`id`, `User`, `nic`, `mobile`, `email`, `bookingdate`, `additionalneeds`, `noofplates`,`advancedpayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', 'Desserts', 50, 10000),
(4, 'Janu', '9528439936V,', 778954562, 'wurifimun@mailinator.com', '22-06-2019', 'Cake', 55, 7500),
(5, 'Kriti', '9992839936V', 778954562, 'pyxe@mailinator.com', '1974-11-28', 'Desserts', 100, 22000),
(6, 'Shaan', '9702333936V', 778954562, 'np@gmail.com', '25-06-2019', 'Buffet', 75, 5000);

-- --------------------------------------------------------

CREATE TABLE `venues` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(200) DEFAULT NULL,
  `TypeOfVenue` varchar(20) NOT NULL,
  `WorkingDays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `venues`
--

INSERT INTO `venues` (`id`, `resourcename`, `TypeOfVenue`, `WorkingDays`, `Location`, `filename`, `path`) VALUES
(13, 'Amirtha Mahal', 'Party Hall', 'Malabe', 'Weekend', 'venue1.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\VenueImg\\venue1.jpg'),
(14, 'Hotel East Lagoon', 'Wedding Hall', 'Kandy', 'Weekdays ','venue2.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\VenueImg\\venue2.jpg');
-- --------------------------------------------------------

CREATE TABLE `venuesbooking` (
  `id` int(11) NOT NULL,
  `User` varchar(100) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `additionalservices` varchar(60) NOT NULL,
  `noofguests` int(11) NOT NULL,
  `advancedpayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `venuesbooking`
--

INSERT INTO `venuesbooking` (`id`, `User`, `nic`, `mobile`, `email`, `bookingdate`, `additionalservices`, `noofguests`,`advancedpayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', 'Decors', 50, 10000),
(4, 'Janu', '9528439936V,', 778954562, 'wurifimun@mailinator.com', '22-06-2019', 'Cake', 55, 7500),
(5, 'Kriti', '9992839936V', 778954562, 'pyxe@mailinator.com', '1974-11-28', 'Decors', 100, 22000),
(6, 'Shaan', '9702333936V', 778954562, 'np@gmail.com', '25-06-2019', 'Cake', 75, 5000);

--
-- Table structure for table `photography`
--

CREATE TABLE `photographys` (
  `id` int(11) NOT NULL,
  `studioname` varchar(200) DEFAULT NULL,
  `AvailableServices` varchar(20) NOT NULL,
  `WorkingDays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photographys`
--

INSERT INTO `photographys` (`id`, `studioname`, `AvailableServices`, `WorkingDays`, `Location`, `filename`, `path`) VALUES
(13, 'Amirtha Caterings', 'Breakfast,Dinner', 'Weekend', 'Malabe', 'catering1.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\catering1.jpg'),
(14, 'Party Caterings', 'Dinner' , 'Weekdays ', 'Kandy', 'catering2.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\catering2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `photographysbooking`
--

CREATE TABLE `photographysbooking` (
  `id` int(11) NOT NULL,
  `User` varchar(100) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `studioname` varchar(60) NOT NULL,
  `packagename` varchar(60) NOT NULL,
  `advancedpayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photographysbooking`
--

INSERT INTO `photographysbooking` (`id`, `User`, `nic`, `mobile`, `email`, `bookingdate`, `studioname`, `packagename`,`advancedpayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', 'Desserts', 'wedding', 10000),
(4, 'Janu', '9528439936V,', 778954562, 'wurifimun@mailinator.com', '22-06-2019', 'Cake', 'birthday', 7500),
(5, 'Kriti', '9992839936V', 778954562, 'pyxe@mailinator.com', '1974-11-28', 'Desserts', 'wedding', 22000),
(6, 'Shaan', '9702333936V', 778954562, 'np@gmail.com', '25-06-2019', 'Buffet', 'birthday', 5000);

-- --------------------------------------------------------
-- --------------------------------------------------------

--
-- Table structure for table `entertainments`
--

CREATE TABLE `entertainments` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(200) DEFAULT NULL,
  `typeofentertainment` varchar(20) NOT NULL,
  `WorkingDays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entertainments`
--

INSERT INTO `entertainments` (`id`, `resourcename`, `typeofentertainment`, `WorkingDays`, `Location`, `filename`, `path`) VALUES
(13, 'Amirtha Entertainments', 'DJ Music', 'Weekend', 'Malabe', 'entertainment1.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\EntertainmentImg\\entertainment1.jpg'),
(14, 'DJ Black', 'Disco' , 'Weekdays ', 'Kandy', 'entertainment2.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\EntertainmentImg\\entertainment2.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `entertainmentsbooking`
--

CREATE TABLE `entertainmentsbooking` (
  `id` int(11) NOT NULL,
  `User` varchar(100) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `additionalneeds` varchar(60) NOT NULL,
  `noofguests` int(11) NOT NULL,
  `advancedpayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entertainmentsbooking`
--

INSERT INTO `entertainmentsbooking` (`id`, `User`, `nic`, `mobile`, `email`, `bookingdate`, `additionalneeds`, `noofguests`,`advancedpayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', 'DJ Music', 50, 10000),
(4, 'Janu', '9528439936V,', 778954562, 'wurifimun@mailinator.com', '22-06-2019', 'Dance', 55, 7500),
(5, 'Kriti', '9992839936V', 778954562, 'pyxe@mailinator.com', '1974-11-28', 'Disco', 100, 22000),
(6, 'Shaan', '9702333936V', 778954562, 'np@gmail.com', '25-06-2019', 'DJ Music', 75, 5000);

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
(1, 'Kisho', 'Kisho', 772654544, 'Jaffna', 'np@gmail.com', '1234'),
(2, 'Viki', 'Viki', 772564544, 'Batticaloa', 'asd@gmail.com', '5678 ');

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
ALTER TABLE `caterings`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cateringsbooking`
--
ALTER TABLE `cateringsbooking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venue`
--
ALTER TABLE `venues`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `venuebooking`
--
ALTER TABLE `venuesbooking`
  ADD PRIMARY KEY (`id`);
  
--
-- Indexes for table `photography`
--
ALTER TABLE `photographys`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `photographysbooking`
--
ALTER TABLE `photographysbooking`
  ADD PRIMARY KEY (`id`);
--
-- Indexes for table `entertainments`
--
ALTER TABLE `entertainments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `entertainmentsbooking`
--
ALTER TABLE `entertainmentsbooking`
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
ALTER TABLE `caterings`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `cateringsbooking`
--
ALTER TABLE `cateringsbooking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `venue`
--
ALTER TABLE `venues`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `venuebooking`
--
ALTER TABLE `venuesbooking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `photography`
--
ALTER TABLE `photographys`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `photographysbooking`
--
ALTER TABLE `photographysbooking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `entertainments`
--
ALTER TABLE `entertainments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `entertainmentsbooking`
--
ALTER TABLE `entertainmentsbooking`
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
