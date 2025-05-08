import { AppBar, Box, Button, IconButton, Toolbar, Typography } from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';

export default function Header() {
    return (
      <Box sx={{ flexGrow: 1 }}>
        <AppBar position="static" color="info">
          <Toolbar>
            <img src={'/images/logo.png'} width={100} height={100} alt="gapsi logo"/>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              e-Commerce Gapsi
            </Typography>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >
              <MenuIcon />
            </IconButton>
          </Toolbar>
        </AppBar>
      </Box>
    );
  }