set cm=blowfish2
let mapleader=" "
noremap <leader>r :silent w !sonic_pi<CR>
noremap <leader>S :call system("sonic_pi stop")<CR>

iab psvm public static void main(String[] args){<CR>}<esc>O
iab sout System.out.println("");<esc>2hi
iab sop System.out.println("");<esc>2hi
iab syserr System.err.println("");<esc>2hi
iab sep System.err.println("");<esc>2hi

iab forl for (int i = 0; i < ; i++) {<esc>7hi
iab tryb try {<CR>} catch (Exception ex) {<CR> ex.printStackTrace();<CR>}<esc>hx3ko
iab const public static final int

iab ctm System.currentTimeMillis()
iab slept try {<CR> Thread.sleep();<CR>}<esc>hxA catch(Exception ex) {<CR> ex.printStackTrace();<CR>}<esc>hx3k$hi
iab teh the

set clipboard=unnamed
inoremap jk <ESC>
set ruler
set nocompatible
set showmode
set tabstop=4
set shiftwidth=4
set expandtab
set noautoindent
set smartindent
set wildmenu
set number
let loaded_matchparen = 1
set encoding=utf-8
set statusline=%F:
set statusline+=%l:%v
set laststatus=2


filetype plugin indent on

