-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2021 at 11:41 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `author` varchar(200) NOT NULL,
  `bookisbn` varchar(100) NOT NULL,
  `bookdesc` varchar(1000) DEFAULT NULL,
  `genreid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookid`, `title`, `author`, `bookisbn`, `bookdesc`, `genreid`) VALUES
(12, 'Harry Potter', 'J. K. Rowling', '9-47-5474', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 9),
(13, 'The Hobbit', 'J. R. R. Tolkien', '9-75-765-7', 'jhdhjdsajhsdsad', 9),
(14, 'She: A History of Adventure', 'H. Rider Haggard', '5-7-5477', 'eyyrreyeyreyer', 10);

-- --------------------------------------------------------

--
-- Table structure for table `borrowbook`
--

CREATE TABLE `borrowbook` (
  `borrowid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `date_start` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowbook`
--

INSERT INTO `borrowbook` (`borrowid`, `bookid`, `studentid`, `date_start`) VALUES
(7, 14, 1526675, '2021-02-01'),
(8, 12, 1903745, '2021-03-02');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `genreid` int(11) NOT NULL,
  `genrename` varchar(100) NOT NULL,
  `catid` enum('fiction','nonfiction') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`genreid`, `genrename`, `catid`) VALUES
(3, 'Action', 'fiction'),
(4, 'Comedy', 'fiction'),
(5, 'Research', 'nonfiction'),
(6, 'Romance', 'fiction'),
(7, 'Art/architecture', 'nonfiction'),
(8, 'Biography', 'nonfiction'),
(9, 'Fantasy', 'fiction'),
(10, 'Adventure', 'fiction');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `libid` int(11) NOT NULL,
  `libname` varchar(200) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`libid`, `libname`, `password`) VALUES
(18106334, 'Natalie Sagnoy', 'natalie777');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentid` int(11) NOT NULL,
  `studentname` varchar(200) NOT NULL,
  `studentcourse` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentid`, `studentname`, `studentcourse`) VALUES
(1526675, 'Christine Sagnoy', 'BS-IT'),
(1903745, 'Kayla Lim', 'BS-CS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookid`),
  ADD UNIQUE KEY `bookid` (`bookid`),
  ADD KEY `genreid` (`genreid`);

--
-- Indexes for table `borrowbook`
--
ALTER TABLE `borrowbook`
  ADD PRIMARY KEY (`borrowid`),
  ADD UNIQUE KEY `borrowid` (`borrowid`),
  ADD KEY `bookid` (`bookid`),
  ADD KEY `studentid` (`studentid`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`genreid`),
  ADD UNIQUE KEY `genreid` (`genreid`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`libid`),
  ADD UNIQUE KEY `libid` (`libid`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentid`),
  ADD UNIQUE KEY `studentid` (`studentid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `borrowbook`
--
ALTER TABLE `borrowbook`
  MODIFY `borrowid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `genreid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`genreid`) REFERENCES `genre` (`genreid`);

--
-- Constraints for table `borrowbook`
--
ALTER TABLE `borrowbook`
  ADD CONSTRAINT `borrowbook_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`),
  ADD CONSTRAINT `borrowbook_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `student` (`studentid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
