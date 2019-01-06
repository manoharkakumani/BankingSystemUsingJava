-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2019 at 06:32 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankserver`
--

-- --------------------------------------------------------

--
-- Table structure for table `160040342`
--

CREATE TABLE `160040342` (
  `id` int(11) NOT NULL,
  `cd` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `160040342`
--

INSERT INTO `160040342` (`id`, `cd`, `amount`, `reason`, `balance`) VALUES
(1, 'Credited', 10000, 'Self Deposit', 10000),
(2, 'Credited', 500, 'Self Deposit', 10500),
(3, 'Debited ', 500, 'WithDrawal', 10000),
(4, 'Debited ', 25, 'Transfer', 9975),
(5, 'Credited', 25, 'Transfer', 10000),
(6, 'Debited ', 12, 'Transfer', 9988),
(7, 'Credited', 12, 'Transfer', 10000),
(8, 'Debited ', 10000, 'WithDrawal', 12),
(9, 'Credited', 9988, 'Self Deposit', 10000),
(10, 'Credited', 200, 'Transfer', 10200),
(11, 'Credited', 122, 'Transfer', 10322);

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(225) NOT NULL,
  `password` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'kakumani', 'kakumani');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(225) DEFAULT NULL,
  `username` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `occupation` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `acno` varchar(225) DEFAULT NULL,
  `actype` varchar(225) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `branch` varchar(225) DEFAULT NULL,
  `phone` varchar(225) DEFAULT NULL,
  `address` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `occupation`, `email`, `acno`, `actype`, `balance`, `branch`, `phone`, `address`) VALUES
(1, 'K.MANOHAR', 'manohar', 'manohar', 'Student', 'manoharkakumani@gmail.com', '160040342', 'Savings', 100322, 'Tangutur', '8186025553', 'Tangutur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `160040342`
--
ALTER TABLE `160040342`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `160040342`
--
ALTER TABLE `160040342`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
