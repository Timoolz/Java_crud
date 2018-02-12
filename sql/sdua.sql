-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2018 at 03:35 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sdua`
--

-- --------------------------------------------------------

--
-- Table structure for table `bug`
--

CREATE TABLE `bug` (
  `bug_id` int(100) NOT NULL,
  `bug_title` varchar(1000) NOT NULL,
  `bug_desc` varchar(10000) NOT NULL,
  `status` varchar(10) NOT NULL,
  `severity` varchar(15) NOT NULL,
  `user_id` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bug`
--

INSERT INTO `bug` (`bug_id`, `bug_title`, `bug_desc`, `status`, `severity`, `user_id`) VALUES
(1, 'error in post module', 'Its not working', 'ACTIVE', 'CRITICAL', 'aa1'),
(2, 'Bug correction', 'Database upload', 'FIXED', 'MODERATE', 'aa2'),
(3, 'Small error', 'My personal error', 'FIXED', 'SUBSTANTIAL', 'aa1'),
(4, 'Final test error', 'CHecking final test', 'FIXED', 'SUBSTANTIAL', 'aa2'),
(8, 'Final test error', 'Random CHecking final test', 'FIXED', 'MODERATE', 'aa2'),
(7, 'New user verification', 'Not working', 'ACTIVE', 'SEVERE', 'string'),
(9, 'Bigger than Small error', 'My random personal error', 'ACTIVE', 'SEVERE', 'aa1'),
(10, 'ANotherSmall error', 'My personal error', 'FIXED', 'SUBSTANTIAL', 'aa1'),
(11, 'string', 'string', 'ACTIVE', 'LOW', 'string');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` varchar(111) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(111) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `first_name`, `last_name`) VALUES
('001', 'olamide', 'Laleye'),
('002', 'ozioma', 'ogbe');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bug`
--
ALTER TABLE `bug`
  ADD PRIMARY KEY (`bug_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bug`
--
ALTER TABLE `bug`
  MODIFY `bug_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
