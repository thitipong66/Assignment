-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2018 at 10:07 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scb_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `application_data`
--

CREATE TABLE `application_data` (
  `application_id` varchar(40) NOT NULL,
  `running_number` int(11) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `application_type` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `application_data`
--

INSERT INTO `application_data` (`application_id`, `running_number`, `created_date`, `application_type`) VALUES
('ab2123-1239fe-321486802', 3, '2018-01-20', 'B'),
('ab2123-123d8e-938476800', 1, '2018-01-20', 'A'),
('ab2123-12a128-448846801', 2, '2018-01-20', 'A'),
('ab2123-3234f3-549876803', 4, '2018-01-20', 'C');

-- --------------------------------------------------------

--
-- Table structure for table `application_form_type_a`
--

CREATE TABLE `application_form_type_a` (
  `application_id` varchar(40) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `field_a` varchar(255) DEFAULT NULL,
  `field_b` varchar(255) DEFAULT NULL,
  `field_c` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `application_form_type_a`
--

INSERT INTO `application_form_type_a` (`application_id`, `user_id`, `field_a`, `field_b`, `field_c`) VALUES
('ab2123-123d8e-938476800', 1, 'Test1', 'Test2', 'Test3'),
('ab2123-12a128-448846801', 2, 'Test4', 'Test5', 'Test6');

-- --------------------------------------------------------

--
-- Table structure for table `application_form_type_b`
--

CREATE TABLE `application_form_type_b` (
  `application_id` varchar(40) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `field_d` varchar(255) DEFAULT NULL,
  `field_e` varchar(255) DEFAULT NULL,
  `field_f` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `application_form_type_b`
--

INSERT INTO `application_form_type_b` (`application_id`, `user_id`, `field_d`, `field_e`, `field_f`) VALUES
('ab2123-1239fe-321486802', 108, 'Test1', 'Test2', 'Test3');

-- --------------------------------------------------------

--
-- Table structure for table `application_form_type_c`
--

CREATE TABLE `application_form_type_c` (
  `application_id` varchar(40) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `field_h` varchar(255) DEFAULT NULL,
  `field_i` varchar(255) DEFAULT NULL,
  `field_j` varchar(255) DEFAULT NULL,
  `field_k` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `application_form_type_c`
--

INSERT INTO `application_form_type_c` (`application_id`, `user_id`, `field_h`, `field_i`, `field_j`, `field_k`) VALUES
('ab2123-3234f3-549876803', 109, 'Test1', 'Test2', 'Test3', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_profile`
--

CREATE TABLE `user_profile` (
  `user_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `address3` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_profile`
--

INSERT INTO `user_profile` (`user_id`, `name`, `address1`, `address2`, `address3`) VALUES
(1, 'Steve Jobs', '510 Sample Street', 'USA', NULL),
(2, 'Bill Gates', '888 Sample Street', 'USA', NULL),
(3, 'Elon Musk', '101 Sample Street', 'USA', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application_data`
--
ALTER TABLE `application_data`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `application_form_type_a`
--
ALTER TABLE `application_form_type_a`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `application_form_type_b`
--
ALTER TABLE `application_form_type_b`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `application_form_type_c`
--
ALTER TABLE `application_form_type_c`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `user_profile`
--
ALTER TABLE `user_profile`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
