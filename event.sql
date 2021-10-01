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
(1, 'Admin', '123');

-- --------------------------------------------------------
-- Table structure for table `catering`
--

CREATE TABLE `catering` (
  `id` int(11) NOT NULL,
  `cateringname` varchar(200) DEFAULT NULL,
  `CateringMenuDetails` varchar(20) NOT NULL,
  `WorkingDays` varchar(200) NOT NULL,
  `Location` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table `catering`
--

INSERT INTO `catering` (`id`, `cateringname`, `CateringMenuDetails`, `WorkingDays`, `Location`, `filename`, `path`) VALUES
(13, 'Normal', 'sss', 'Tv', 'jdjd', 'Deluxe-Catering-at-Yara-Galle-Fort.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\Deluxe-Room-at-Yara-Galle-Fort.jpg'),
(14, 'Luxary', 'dff', 'Tv , Ac , Wifi ', 'ddd', 'images.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\CateringImg\\images.jpg');
=======

>>>>>>> 4648220ed7988fb65d95ce3a1fd8256fadf8456b
--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `id` int(11) NOT NULL,
  `resourcename` varchar(200) DEFAULT NULL,
  `typeofvenue` varchar(20) NOT NULL,
  `location` varchar(200) NOT NULL,
  `workingdays` varchar(20) NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`id`, `ResourceName`, `TypeOfVenue`, `Location`, `WorkingDays`, `filename`, `path`) VALUES
(13, 'Lakshi Hall Booking', 'Wedding Hall', 'Batti, 'Weekend', 'Deluxe-Room-at-Yara-Galle-Fort.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\VenueImg\\Deluxe-Room-at-Yara-Galle-Fort.jpg'),
(14, 'Raj Hall Booking', 'birthday hall' , 'Colombo', 'Weekday', 'images.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\VenueImg\\images.jpg'),
(15, 'Alen Hall Booking', 'Wedding Hall' , 'Kandy', 'Weekday', '205684046.jpg', 'D:\\Users\\PC\\eclipse-workspace\\Test2\\WebContent\\VenueImg\\205684046.jpg'),

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
-- Table structure for table `cateringsbooking`
--

CREATE TABLE `cateringsbooking` (
  `id` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `mobile` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `bookingdate` varchar(60) NOT NULL,
  `additionalneeds` varchar(60) NOT NULL,
  `noofplates` int(11) NOT NULL,
  `AdvancedPayment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cateringsbooking`
--

INSERT INTO `cateringsbooking` (`id`, `user`, `nic`, `mobile`, `email`, `bookingdate`, `additionalneeds`, `noofplates`, `AdvancedPayment`) VALUES
(1, 'Kirujan', '9702839936V', 778954562, 'nkiru@gmail.com', '22-01-2019', '25-01-2019', 5, 1000),
(4, 'Est optio ullamco q', 'fhjk,', 5, 'wurifimun@mailinator.com', 'Ab sunt placeat et ', 'Mollit qui excepturi', 5, 5),
(5, 'Maxime voluptates qu', 'Quia ali', 95, 'pyxe@mailinator.com', '1974-11-28', 'Rerum ipsum dolores ', 10, 22),
(6, 'Pranavan ', '46004266565', 70323231, 'np@gmail.com', '22/10/2020', '22/10/2020', 5, 5000);

-- --------------------------------------------------------
--
=======
>>>>>>> 4648220ed7988fb65d95ce3a1fd8256fadf8456b
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);


-- Indexes for table `catering`
--
ALTER TABLE `catering`
  ADD PRIMARY KEY (`id`);

=======
>>>>>>> 4648220ed7988fb65d95ce3a1fd8256fadf8456b
--
-- Indexes for table `venue`
--
ALTER TABLE `venue`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cateringsbooking`
--
ALTER TABLE `cateringsbooking`
  ADD PRIMARY KEY (`id`);


--
=======
>>>>>>> 4648220ed7988fb65d95ce3a1fd8256fadf8456b
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `catering`
--
ALTER TABLE `catering`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `cateringsbooking`
--
ALTER TABLE `cateringsbooking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
  
--
=======

--
>>>>>>> 4648220ed7988fb65d95ce3a1fd8256fadf8456b
-- AUTO_INCREMENT for table `venue`
--
ALTER TABLE `venue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;


--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
