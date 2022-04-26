-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2021 at 09:43 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thesis1`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `dept_ID` int(11) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`dept_ID`, `dept_name`) VALUES
(1, 'maintenance'),
(2, 'security'),
(3, 'admins');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_ID` varchar(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `dept_ID` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_ID`, `first_name`, `last_name`, `middle_name`, `birth_date`, `sex`, `address`, `number`, `hire_date`, `dept_ID`, `username`, `password`) VALUES
('emp7lF', 'admin', 'admin', 'admin', '2021-11-05', 'male', 'dawdwda', '3213131231', NULL, 3, 'admin', 'SubdivE4xP'),
('emp9lI', 'emp empemp', 'emp empemp', 'emp empemp', '2021-11-05', 'emp empemp', 'emp empemp', '32132132', NULL, 2, 'emp empemp', 'SubdivE9iS');

-- --------------------------------------------------------

--
-- Table structure for table `entry`
--

CREATE TABLE `entry` (
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `entry`
--

INSERT INTO `entry` (`name`) VALUES
('ded'),
('ID: RF0fR\nType: Relative/Friends\nName: Rodrigo, Bryan James Sanaga\nContact Number: 09090999990'),
('RF9pV');

-- --------------------------------------------------------

--
-- Table structure for table `homeowners`
--

CREATE TABLE `homeowners` (
  `homeowner_ID` varchar(50) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `lot_number` varchar(255) DEFAULT NULL,
  `block_number` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(20) DEFAULT NULL,
  `tel_number` varchar(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `homeowners`
--

INSERT INTO `homeowners` (`homeowner_ID`, `first_name`, `middle_name`, `last_name`, `birth_date`, `street`, `lot_number`, `block_number`, `mobile_number`, `tel_number`, `username`, `password`, `sex`) VALUES
('SubdO4cE', 'own', 'own', 'own', '2021-11-04', 'own', 'own', 'own', '09551334393', '33123123213', 'own', 'SubdivO4xH', 'ownown');

-- --------------------------------------------------------

--
-- Table structure for table `logbook`
--

CREATE TABLE `logbook` (
  `visitorNo` int(11) NOT NULL,
  `visitor_ID` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `visitorType` varchar(255) DEFAULT NULL,
  `plateNumber` varchar(255) DEFAULT NULL,
  `homeownerName` varchar(255) DEFAULT NULL,
  `emp_ID` varchar(255) DEFAULT NULL,
  `date_in` date DEFAULT current_timestamp(),
  `time_in` time DEFAULT current_timestamp(),
  `date_out` date DEFAULT NULL,
  `time_out` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `logbook`
--

INSERT INTO `logbook` (`visitorNo`, `visitor_ID`, `first_name`, `last_name`, `visitorType`, `plateNumber`, `homeownerName`, `emp_ID`, `date_in`, `time_in`, `date_out`, `time_out`) VALUES
(25, 'RF4dQ', 'rel', 'rel', 'Relative/friends', 'KV@-323', 'own own', NULL, '2021-11-26', '13:23:51', NULL, NULL),
(26, 'RF4dQ', 'rel', 'rel', 'Relative/friends', 'KV@-323', 'own own', NULL, '2021-11-26', '13:33:27', NULL, NULL),
(27, 'RF4dQ', 'rel', 'rel', 'Relative/friends', 'KV@-323', 'own own', NULL, '2021-11-26', '13:33:58', NULL, NULL),
(28, 'SubdO4cE', 'own', 'own', 'Homeowner', 'KVK232', NULL, NULL, '2021-11-26', '13:34:38', NULL, NULL),
(29, 'emp7lF', 'admin', 'admin', 'Employee', '', NULL, NULL, '2021-11-26', '13:34:59', '2021-11-26', '13:35:55'),
(30, 'Del7nI', 'del', 'del', 'delivery', '', 'own own', NULL, '2021-11-26', '13:35:24', '2021-11-26', '13:35:42');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `visitor_ID` varchar(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `number` varchar(13) DEFAULT NULL,
  `visitorType_ID` int(11) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `plateNumber` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`visitor_ID`, `username`, `password`, `first_name`, `middle_name`, `last_name`, `address`, `birth_date`, `number`, `visitorType_ID`, `sex`, `plateNumber`) VALUES
('Del7nI', 'del', 'subdivD0qA', 'del', 'del', 'del', 'del', '2021-11-05', '31232131232', 3, 'del', 'del'),
('RF4dQ', 'rel', 'subdivV0bK', 'rel', 'rel', 'rel', 'rel', '2021-11-10', '31232212132', 1, 'rel', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `visitortype`
--

CREATE TABLE `visitortype` (
  `visitorType_ID` int(10) NOT NULL,
  `vis_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitortype`
--

INSERT INTO `visitortype` (`visitorType_ID`, `vis_type`) VALUES
(1, 'Relative/friends'),
(2, 'taxi'),
(3, 'delivery');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`dept_ID`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_ID`),
  ADD KEY `dept_ID` (`dept_ID`);

--
-- Indexes for table `homeowners`
--
ALTER TABLE `homeowners`
  ADD PRIMARY KEY (`homeowner_ID`);

--
-- Indexes for table `logbook`
--
ALTER TABLE `logbook`
  ADD PRIMARY KEY (`visitorNo`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`visitor_ID`),
  ADD KEY `visitorType_ID` (`visitorType_ID`);

--
-- Indexes for table `visitortype`
--
ALTER TABLE `visitortype`
  ADD PRIMARY KEY (`visitorType_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `dept_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `logbook`
--
ALTER TABLE `logbook`
  MODIFY `visitorNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `visitortype`
--
ALTER TABLE `visitortype`
  MODIFY `visitorType_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`dept_ID`) REFERENCES `departments` (`dept_ID`);

--
-- Constraints for table `visitor`
--
ALTER TABLE `visitor`
  ADD CONSTRAINT `visitor_ibfk_1` FOREIGN KEY (`visitorType_ID`) REFERENCES `visitortype` (`visitorType_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
