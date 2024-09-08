$(document).ready(function() {
    $('#searchBook').on('input', function() {
        const query = $(this).val();
        if (query.length < 3) {
            $('#bookSelectContainer').hide();
            $('#noBooksFound').addClass('d-none');
            return;
        }

        $.ajax({
            url: '/books/rest-search',
            type: 'GET',
            data: { query: query },
            success: function(books) {
                const $select = $('#bookSelect');
                $select.empty();

                if (books.length > 0) {
                    books.forEach(function(book) {
                        const option = $('<option>')
                            .val(book.id)
                            .text(`${book.title} (ISBN: ${book.isbn}) - ${book.stock.available}/${book.stock.quantity} disponíveis`);
                        $select.append(option);
                    });

                    $('#bookSelectContainer').show();
                    $('#noBooksFound').addClass('d-none');
                } else {
                    $('#bookSelectContainer').hide();
                    $('#noBooksFound').removeClass('d-none');
                }
            },
            error: function() {
                console.error('Erro ao buscar livros');
                $('#bookSelectContainer').hide();
                $('#noBooksFound').removeClass('d-none');
            }
        });
    });
});