function print() {
    var printwindow = window.open('', 'PRINT', 'height=400,width=600');

    printwindow.document.write('<html><head><title>' + document.title  + '</title>');
    printwindow.document.write('</head><body >');
    printwindow.document.write(document.getElementById('recipe').innerHTML);
    printwindow.document.write('<hr><p>Powered by TastyLabs</p></body></html>');

    printwindow.document.close(); // necessary for IE >= 10
    printwindow.focus(); // necessary for IE >= 10*/

    printwindow.print();
    printwindow.close();

    return true;
}
